package com.turi.languagelearning.presentation.screens.language

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.turi.languagelearning.core.constants.Languages
import com.turi.languagelearning.presentation.theme.GameBackground

@Composable
fun LanguageSelectionScreen(
    onLanguageSelected: (motherLanguage: String, targetLanguage: String) -> Unit,
    onLoginClicked: () -> Unit,
    viewModel: LanguageSelectionViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        GameBackground,
                        GameBackground.copy(alpha = 0.9f)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = when (uiState.selectionStep) {
                    LanguageSelectionStep.SelectMotherLanguage -> "What language do you speak?"
                    LanguageSelectionStep.SelectTargetLanguage -> "What language do you want to learn?"
                    LanguageSelectionStep.ReadyToStart -> "Ready to start your journey?"
                },
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            when (uiState.selectionStep) {
                LanguageSelectionStep.SelectMotherLanguage -> {
                    LanguageList(
                        languages = Languages.POPULAR_LANGUAGES,
                        selectedLanguage = uiState.motherLanguage,
                        onLanguageSelected = { viewModel.selectMotherLanguage(it) }
                    )
                }
                
                LanguageSelectionStep.SelectTargetLanguage -> {
                    LanguageList(
                        languages = Languages.POPULAR_LANGUAGES.filter { it.code != uiState.motherLanguage },
                        selectedLanguage = uiState.targetLanguage,
                        onLanguageSelected = { viewModel.selectTargetLanguage(it) }
                    )
                }
                
                LanguageSelectionStep.ReadyToStart -> {
                    ReadyToStartContent(
                        motherLanguage = Languages.getNativeName(uiState.motherLanguage ?: ""),
                        targetLanguage = Languages.getNativeName(uiState.targetLanguage ?: ""),
                        onStartJourney = {
                            onLanguageSelected(
                                uiState.motherLanguage ?: "",
                                uiState.targetLanguage ?: ""
                            )
                        },
                        onLoginClicked = onLoginClicked
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Back button (except for first step)
            if (uiState.selectionStep != LanguageSelectionStep.SelectMotherLanguage) {
                OutlinedButton(
                    onClick = { viewModel.goBack() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Go Back")
                }
            }
        }
    }
}

@Composable
private fun LanguageList(
    languages: List<com.turi.languagelearning.core.constants.LanguageOption>,
    selectedLanguage: String?,
    onLanguageSelected: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(languages) { language ->
            LanguageItem(
                language = language,
                isSelected = selectedLanguage == language.code,
                onSelected = { onLanguageSelected(language.code) }
            )
        }
    }
}

@Composable
private fun LanguageItem(
    language: com.turi.languagelearning.core.constants.LanguageOption,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelected() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) 
                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
            else 
                MaterialTheme.colorScheme.surface.copy(alpha = 0.1f)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = language.nativeName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = language.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
            }
            
            if (isSelected) {
                RadioButton(
                    selected = true,
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

@Composable
private fun ReadyToStartContent(
    motherLanguage: String,
    targetLanguage: String,
    onStartJourney: () -> Unit,
    onLoginClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.1f)
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "You speak:",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
                Text(
                    text = motherLanguage,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "You want to learn:",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
                Text(
                    text = targetLanguage,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        Button(
            onClick = onStartJourney,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Start Your Journey",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
        
        TextButton(
            onClick = onLoginClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Account to Save Progress")
        }
    }
}