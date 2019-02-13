package au.com.ultralogs.elliotwave.ui.main.view

import android.content.Context
import android.util.Log
import android.widget.TextView
import au.com.ultralogs.elliotwave.R
import au.com.ultralogs.elliotwave.ui.base.intreractor.SwapDataSample
import com.mindorks.placeholderview.annotations.*
import com.mindorks.placeholderview.annotations.swipe.SwipeView

//binding data int swap layouts
@NonReusable
@Layout(R.layout.swapcards)
class SwapCardView(private val context: Context, private val jobdata: SwapDataSample) {
    @View(R.id.text1)
    lateinit var text1: TextView

    @SwipeView
    lateinit var swipe: android.view.View

    @JvmField
    @Position
    var position: Int = 0

    @Resolve
    fun onResolved() {
        //sometext.disa
        Log.e("logs", jobdata.sometext)
        text1.text = jobdata.sometext
    }
}