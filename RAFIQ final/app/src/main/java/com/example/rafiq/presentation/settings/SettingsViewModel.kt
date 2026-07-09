package com.example.rafiq.presentation.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rafiq.data.local.UserPreferences
import com.example.rafiq.util.BackupManager
import com.example.rafiq.util.LocaleManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    @ApplicationContext private val appContext: Context
) : ViewModel() {

    val emergencyContact: StateFlow<String> = userPreferences.emergencyContact
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "+1234567890")

    val darkTheme: StateFlow<String> = userPreferences.darkTheme
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "system")

    val language: StateFlow<String> = userPreferences.language
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "en")

    val fontSize: StateFlow<String> = userPreferences.fontSize
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "normal")

    val fontFamily: StateFlow<String> = userPreferences.fontFamily
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "default")

    val speechRate: StateFlow<Float> = userPreferences.speechRate
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 1.0f)

    fun saveEmergencyContact(contact: String) {
        viewModelScope.launch {
            userPreferences.setEmergencyContact(contact)
        }
    }

    fun setDarkTheme(mode: String) {
        viewModelScope.launch {
            userPreferences.setDarkTheme(mode)
        }
    }

    fun setLanguage(lang: String) {
        viewModelScope.launch {
            userPreferences.setLanguage(lang)
            LocaleManager.persistLanguage(appContext, lang)
        }
    }

    fun setFontSize(size: String) {
        viewModelScope.launch {
            userPreferences.setFontSize(size)
        }
    }

    fun setFontFamily(family: String) {
        viewModelScope.launch {
            userPreferences.setFontFamily(family)
        }
    }

    fun setSpeechRate(rate: Float) {
        viewModelScope.launch {
            userPreferences.setSpeechRate(rate)
        }
    }

    fun backupData(onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val result = BackupManager.backupData(appContext)
            result.fold(
                onSuccess = { path -> onResult(true, path) },
                onFailure = { e -> onResult(false, e.message ?: "Backup failed") }
            )
        }
    }

    fun restoreData(onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val result = BackupManager.restoreData(appContext)
            result.fold(
                onSuccess = { onResult(true, "Restore successful") },
                onFailure = { e -> onResult(false, e.message ?: "Restore failed") }
            )
        }
    }
}
