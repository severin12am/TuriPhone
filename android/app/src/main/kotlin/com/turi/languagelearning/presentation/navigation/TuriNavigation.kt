package com.turi.languagelearning.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.turi.languagelearning.presentation.screens.auth.LoginScreen
import com.turi.languagelearning.presentation.screens.dialogue.DialogueScreen
import com.turi.languagelearning.presentation.screens.language.LanguageSelectionScreen
import com.turi.languagelearning.presentation.screens.game.GameScreen
import com.turi.languagelearning.presentation.screens.splash.SplashScreen

@Composable
fun TuriNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToLanguageSelection = {
                    navController.navigate(Screen.LanguageSelection.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                onNavigateToGame = {
                    navController.navigate(Screen.Game.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.LanguageSelection.route) {
            LanguageSelectionScreen(
                onLanguageSelected = { motherLanguage, targetLanguage ->
                    navController.navigate(Screen.Game.route) {
                        popUpTo(Screen.LanguageSelection.route) { inclusive = true }
                    }
                },
                onLoginClicked = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Game.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Game.route) {
            GameScreen(
                onNavigateToDialogue = { characterId, characterName ->
                    navController.navigate(Screen.Dialogue.createRoute(characterId, characterName))
                }
            )
        }
        
        composable(
            route = Screen.Dialogue.route,
            arguments = listOf(
                navArgument("characterId") { type = NavType.StringType },
                navArgument("characterName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId") ?: ""
            val characterName = backStackEntry.arguments?.getString("characterName") ?: ""
            
            DialogueScreen(
                characterId = characterId,
                characterName = characterName,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}