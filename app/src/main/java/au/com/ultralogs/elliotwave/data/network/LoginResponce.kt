package au.com.ultralogs.elliotwave.data.network


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//accruing login results
data class LoginResponse(@Expose
                         @SerializedName("status")
                         var status: Boolean? = null,
                         @Expose
                         @SerializedName("message")
                         var message: String? = null,
                         @Expose
                         @SerializedName("data")
                         var data: data? = null
)