package com.turi.languagelearning.presentation.screens.dialogue

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.turi.languagelearning.domain.model.Dialogue
import com.turi.languagelearning.domain.model.DialogueOption

@Composable
fun DialogueScreen(
    characterId: String,
    characterName: String,
    onBackPressed: () -> Unit,
    viewModel: DialogueViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    LaunchedEffect(characterId) {
        viewModel.startDialogue(characterId, characterName)
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f))
            .padding(16.dp)
    ) {
        // Header
        DialogueHeader(
            characterName = characterName,
            onBackPressed = onBackPressed,
            onSpeakPressed = { viewModel.speakCurrentDialogue() }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Dialogue Content
        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.White)
                }
            }
            
            uiState.currentDialogue != null -> {
                DialogueContent(
                    dialogue = uiState.currentDialogue!!,
                    onOptionSelected = { option ->
                        viewModel.selectDialogueOption(option)
                    },
                    onWordTapped = { word ->
                        viewModel.explainWord(word)
                    }
                )
            }
            
            uiState.error != null -> {
                ErrorMessage(
                    error = uiState.error!!,
                    onRetry = { viewModel.startDialogue(characterId, characterName) }
                )
            }
        }
        
        // Word Explanation Modal
        if (uiState.wordExplanation != null) {
            WordExplanationModal(
                explanation = uiState.wordExplanation!!,
                onDismiss = { viewModel.dismissWordExplanation() }
            )
        }
    }
}

@Composable
private fun DialogueHeader(
    characterName: String,
    onBackPressed: () -> Unit,
    onSpeakPressed: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onBackPressed,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text("← Back", color = Color.White)
        }
        
        Text(
            text = "Talking with $characterName",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        
        Button(
            onClick = onSpeakPressed,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text("🔊 Speak", color = Color.White)
        }
    }
}

@Composable
private fun DialogueContent(
    dialogue: Dialogue,
    onOptionSelected: (DialogueOption) -> Unit,
    onWordTapped: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Character's message
        item {
            CharacterMessage(
                dialogue = dialogue,
                onWordTapped = onWordTapped
            )
        }
        
        // User response options
        if (dialogue.options.isNotEmpty()) {
            item {
                Text(
                    text = "Choose your response:",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            
            items(dialogue.options) { option ->
                DialogueOptionCard(
                    option = option,
                    onSelected = { onOptionSelected(option) }
                )
            }
        }
    }
}

@Composable
private fun CharacterMessage(
    dialogue: Dialogue,
    onWordTapped: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = dialogue.characterName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Main dialogue text - make words tappable
            ClickableText(
                text = dialogue.phrase.text,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                onWordTapped = onWordTapped
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Translation
            Text(
                text = dialogue.phrase.translation,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
            
            // Learning points
            if (dialogue.learningPoints.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                dialogue.learningPoints.forEach { point ->
                    Text(
                        text = "💡 $point",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Composable
private fun DialogueOptionCard(
    option: DialogueOption,
    onSelected: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelected() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Blue.copy(alpha = 0.8f))
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = option.text,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
            
            Text(
                text = option.translation,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f),
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
        }
    }
}

@Composable
private fun ClickableText(
    text: String,
    style: androidx.compose.ui.text.TextStyle,
    color: Color,
    onWordTapped: (String) -> Unit
) {
    // Simple implementation - in production you'd use AnnotatedString
    // For now, just display the text normally and handle taps
    Text(
        text = text,
        style = style,
        color = color,
        modifier = Modifier.clickable {
            // Extract word at tap position - simplified for now
            val words = text.split(" ")
            if (words.isNotEmpty()) {
                onWordTapped(words.first())
            }
        }
    )
}

@Composable
private fun WordExplanationModal(
    explanation: String,
    onDismiss: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Word Explanation",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Button(onClick = onDismiss) {
                    Text("✕")
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = explanation,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun ErrorMessage(
    error: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Error: $error",
            color = Color.Red,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}