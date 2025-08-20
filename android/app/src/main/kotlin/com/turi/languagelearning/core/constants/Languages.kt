package com.turi.languagelearning.core.constants

data class LanguageOption(
    val code: String,
    val name: String,
    val nativeName: String
)

object Languages {
    val POPULAR_LANGUAGES = listOf(
        LanguageOption("en", "English", "English"),
        LanguageOption("ru", "Russian", "Русский"),
        LanguageOption("es", "Spanish", "Español"),
        LanguageOption("fr", "French", "Français"),
        LanguageOption("de", "German", "Deutsch"),
        LanguageOption("it", "Italian", "Italiano"),
        LanguageOption("pt", "Portuguese", "Português"),
        LanguageOption("ar", "Arabic", "العربية"),
        LanguageOption("zh", "Chinese", "中文"),
        LanguageOption("ja", "Japanese", "日本語"),
        LanguageOption("av", "Avar", "Авар мацӀ")
    )
    
    // Supported languages type alias for easier usage
    val SUPPORTED_LANGUAGE_CODES = POPULAR_LANGUAGES.map { it.code }
    
    fun getLanguageByCode(code: String): LanguageOption? {
        return POPULAR_LANGUAGES.find { it.code == code }
    }
    
    fun getLanguageName(code: String): String {
        return getLanguageByCode(code)?.name ?: code
    }
    
    fun getNativeName(code: String): String {
        return getLanguageByCode(code)?.nativeName ?: code
    }
}