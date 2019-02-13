package au.com.ultralogs.elliotwave.data.network


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//performing login request
class LoginRequest {
    data class ServerLoginRequest internal constructor(@Expose
                                                       @SerializedName("username") internal val email: String,
                                                       @Expose
                                                       @SerializedName("password") internal val password: String)
}