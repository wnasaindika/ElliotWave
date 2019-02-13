package au.com.ultralogs.elliotwave.data.network


import au.com.ultralogs.elliotwave.di.ApiKeyInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

/*
*@Description
* Inject public headers and protected headers an using api header this class can use in secured and non secured environment
*
*/
class ApiHeader @Inject constructor(internal val publicApiHeader: PublicApiHeader, internal val protectedApiHeader: ProtectedApiHeader) {
    class PublicApiHeader @Inject constructor(@ApiKeyInfo
                                              @Expose
                                              @SerializedName
                                              ("api_key") val apiKey: String)

    class ProtectedApiHeader @Inject constructor(@Expose
                                                 @SerializedName("api_key") val apiKey: String,
                                                 @Expose
                                                 @SerializedName("user_id") val userId: Long?,
                                                 @Expose
                                                 @SerializedName("access_token") val accessToken: String?)
}