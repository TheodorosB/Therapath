/*
package io.github.theodorosB.therapath.framework.user.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import io.github.theodorosB.therapath.framework.user.datastore.model.UserDatastoreItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserDatastore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    private object PreferencesKeys {
        val UUID = stringPreferencesKey("uuid")
        val IS_LOGIN_SAVED = booleanPreferencesKey("is_login_saved")
        val SELECTED_LOCALE_LANGUAGE = stringPreferencesKey("locale")
    }

    private val userDatastoreItem: Flow<UserDatastoreItem> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val uuid = preferences[PreferencesKeys.UUID] ?: ""
            val isLoginSaved = preferences[PreferencesKeys.IS_LOGIN_SAVED] ?: false
            val selectedLocaleLanguage = preferences[PreferencesKeys.SELECTED_LOCALE_LANGUAGE] ?: ""

            UserDatastoreItem(
                uuid = uuid,
                isLoginSaved = isLoginSaved,
                localeLanguage = selectedLocaleLanguage
            )
        }

    suspend fun updateUserUUID(uuid: String) {
        dataStore.edit {
            it[PreferencesKeys.UUID] = uuid
        }
    }

    fun getUserUUID(): Flow<String> {
        return userDatastoreItem.map {
            it.uuid
        }
    }

    suspend fun updateLoginSaved (isLoginSaved: Boolean) {
        dataStore.edit {
            it[PreferencesKeys.IS_LOGIN_SAVED] = isLoginSaved
        }
    }

    fun getUserDataItem(): Flow<UserDatastoreItem> {
        return userDatastoreItem
    }

    suspend fun updateLocaleLanguage (localeLanguage: String) {
        dataStore.edit {
            it[PreferencesKeys.SELECTED_LOCALE_LANGUAGE] = localeLanguage
        }
    }

    fun getUserLocaleLanguage(): Flow<String> {
        return userDatastoreItem.map {
            it.localeLanguage
        }
    }
}*/
