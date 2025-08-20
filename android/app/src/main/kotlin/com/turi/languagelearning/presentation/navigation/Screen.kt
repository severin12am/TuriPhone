package com.turi.languagelearning.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object LanguageSelection : Screen("language_selection")
    object Login : Screen("login")
    object Game : Screen("game")
    
    // Future screens
    object Dialogue : Screen("dialogue/{characterId}/{characterName}") {
        fun createRoute(characterId: String, characterName: String) = 
            "dialogue/$characterId/$characterName"
    }
    object Quiz : Screen("quiz")
    object Progress : Screen("progress")
    object Settings : Screen("settings")
}