package com.example.worldskills_app.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.onBoardDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "onBoard"
)

class DataStore(
    private val context: Context
) {
    private val isShowOnBoard = booleanPreferencesKey("onBoard")

    val isShowOnBoardFlow = context.onBoardDataStore.data.map { preferences ->
        preferences[isShowOnBoard] ?: false
    }

    suspend fun setOnBoardValue(
        Bool: Boolean = true
    ) {
        context.onBoardDataStore.edit {preference->
            preference[isShowOnBoard] = Bool
        }
    }
}