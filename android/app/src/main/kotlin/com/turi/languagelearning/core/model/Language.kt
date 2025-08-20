package com.turi.languagelearning.core.model

import java.util.*

/**
 * Supported languages for TTS and Speech Recognition
 * Clean, native-first implementation
 */
enum class Language(
    val code: String,
    val displayName: String,
    val nativeName: String,
    val ttsLocale: Locale,
    val speechLocale: Locale,
    val flag: String
) {
    ENGLISH(
        code = "en",
        displayName = "English",
        nativeName = "English",
        ttsLocale = Locale("en", "US"),
        speechLocale = Locale("en", "US"),
        flag = "🇺🇸"
    ),
    RUSSIAN(
        code = "ru",
        displayName = "Russian", 
        nativeName = "Русский",
        ttsLocale = Locale("ru", "RU"),
        speechLocale = Locale("ru", "RU"),
        flag = "🇷🇺"
    ),
    SPANISH(
        code = "es",
        displayName = "Spanish",
        nativeName = "Español", 
        ttsLocale = Locale("es", "ES"),
        speechLocale = Locale("es", "ES"),
        flag = "🇪🇸"
    ),
    ARABIC(
        code = "ar",
        displayName = "Arabic",
        nativeName = "العربية",
        ttsLocale = Locale("ar", "SA"),
        speechLocale = Locale("ar", "SA"),
        flag = "🇸🇦"
    ),
    GERMAN(
        code = "de",
        displayName = "German",
        nativeName = "Deutsch",
        ttsLocale = Locale("de", "DE"),
        speechLocale = Locale("de", "DE"),
        flag = "🇩🇪"
    ),
    JAPANESE(
        code = "ja",
        displayName = "Japanese",
        nativeName = "日本語",
        ttsLocale = Locale("ja", "JP"),
        speechLocale = Locale("ja", "JP"),
        flag = "🇯🇵"
    ),
    CHINESE(
        code = "zh",
        displayName = "Chinese",
        nativeName = "中文",
        ttsLocale = Locale("zh", "CN"),
        speechLocale = Locale("zh", "CN"),
        flag = "🇨🇳"
    ),
    FRENCH(
        code = "fr",
        displayName = "French",
        nativeName = "Français",
        ttsLocale = Locale("fr", "FR"),
        speechLocale = Locale("fr", "FR"),
        flag = "🇫🇷"
    );

    companion object {
        fun fromCode(code: String): Language? {
            return values().find { it.code == code }
        }
        
        fun getAllLanguages(): List<Language> = values().toList()
        
        fun getDefault(): Language = ENGLISH
    }
}