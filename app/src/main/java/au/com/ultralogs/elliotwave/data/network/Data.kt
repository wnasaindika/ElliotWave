package au.com.ultralogs.elliotwave.data.network


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//holding serialize  data for network communications
data class data(@Expose
             @SerializedName("user_id")
             var userId: Long? = null,

             @Expose
             @SerializedName("token")
             var accessToken: String? = null,

             @Expose
             @SerializedName("email")
             var userEmail: String? = null)
