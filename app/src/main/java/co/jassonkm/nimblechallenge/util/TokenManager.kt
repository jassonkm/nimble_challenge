package co.jassonkm.nimblechallenge.util

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Singleton

@Singleton
class TokenManager(context: Context) {
    companion object {
        private const val FILE_NAME = "encrypted_shared_prefs"
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val TOKEN_EXPIRY_TIME = "token_expiry_time"
    }

    private val sharedPreferences: SharedPreferences

    init {
        val masterKeyAlias = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        sharedPreferences = EncryptedSharedPreferences.create(
            context,
            FILE_NAME,
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun saveAccessToken(accessToken: String) {
        sharedPreferences.edit().putString(ACCESS_TOKEN, accessToken).apply()
    }

    fun getAccessToken(): String {
        return sharedPreferences.getString(ACCESS_TOKEN, "") ?: ""
    }

    fun saveRefreshToken(refreshToken: String) {
        sharedPreferences.edit().putString(REFRESH_TOKEN, refreshToken).apply()
    }

    fun getRefreshToken(): String {
        return sharedPreferences.getString(REFRESH_TOKEN, "") ?: ""
    }

    fun saveTokenExpiryTime(expiresIn: Int) {
        val expiryTime = System.currentTimeMillis() + expiresIn * 1000
        sharedPreferences.edit().putLong(TOKEN_EXPIRY_TIME, expiryTime).apply()
    }

    fun hasTokenExpired(): Boolean {
        val expiryTime = sharedPreferences.getLong(TOKEN_EXPIRY_TIME, 0)
        return System.currentTimeMillis() > expiryTime
    }

    fun clearToken() {
        sharedPreferences.edit().clear().apply()
    }
}
