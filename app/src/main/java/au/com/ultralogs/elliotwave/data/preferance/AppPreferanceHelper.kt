package au.com.ultralogs.elliotwave.data.preferance

import android.content.Context
import android.content.SharedPreferences
import au.com.ultralogs.elliotwave.di.PreferenceInfo
import au.com.ultralogs.elliotwave.util.AppConstants
import javax.inject.Inject

class AppPreferanceHelper @Inject constructor(context: Context, @PreferenceInfo private val prefFileName: String) : PreferenceHelper {

    //creating common object for shared preference key
    companion object {
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
    }

    //accessing shared preference
    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    private var editor = mPrefs!!.edit()

    //get logged userd
    override fun getCurrentUserId(): Long? {
        val userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
        return when (userId) {
            AppConstants.NULL_INDEX -> null
            else -> userId
        }
    }

    //save id after login
    override fun setCurrentUserId(userId: Long?) {
        val id = userId ?: AppConstants.NULL_INDEX
        editor.putLong(PREF_KEY_CURRENT_USER_ID, id)
        editor.apply()
    }

    //get access token
    override fun getAccessToken(): String = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    /*
    * @params accessToken
    * saving access token
    */
    override fun setAccessToken(accessToken: String?) {
        editor.putString(PREF_KEY_ACCESS_TOKEN, accessToken)
        editor.apply()
    }
}