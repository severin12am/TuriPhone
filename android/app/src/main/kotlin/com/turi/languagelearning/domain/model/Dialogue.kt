package com.turi.languagelearning.domain.model

data class Phrase(
    val id: String,
    val text: String,
    val translation: String,
    val audioUrl: String? = null,
    val difficulty: Int = 1
)

data class DialogueOption(
    val id: String,
    val text: String,
    val translation: String,
    val nextDialogueId: String? = null,
    val isCorrect: Boolean = true
)

data class Dialogue(
    val id: String,
    val characterName: String,
    val phrase: Phrase,
    val options: List<DialogueOption> = emptyList(),
    val isQuestion: Boolean = false,
    val context: String? = null,
    val learningPoints: List<String> = emptyList()
)

data class DialogueSession(
    val sessionId: String,
    val characterId: String,
    val characterName: String,
    val currentDialogueId: String,
    val language: String,
    val startTime: Long,
    val dialogueHistory: List<String> = emptyList(),
    val isActive: Boolean = true
)

data class ConversationFlow(
    val characterId: String,
    val characterName: String,
    val language: String,
    val dialogues: Map<String, Dialogue>,
    val startDialogueId: String,
    val description: String
)