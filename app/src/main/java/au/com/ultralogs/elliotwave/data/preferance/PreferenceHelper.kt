package au.com.ultralogs.elliotwave.data.preferance

/*
*all method/values saved in shared preference
*/
interface PreferenceHelper {
    fun getCurrentUserId(): Long?
    fun setCurrentUserId(userId: Long?)
    fun getAccessToken(): String?
    fun setAccessToken(accessToken: String?)
}