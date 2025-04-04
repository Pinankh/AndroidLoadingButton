package io.pinankh.sample
/**
 * Created by @Author Pinankh Patel on 15,March,2025
 * Mobile App Developer,
 * Gujarat, INDIA.
 */
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.pinankh.loadingbutton.animatedDrawables.ProgressType
import io.pinankh.loadingbutton.customViews.CircularProgressButton
import io.pinankh.loadingbutton.customViews.ProgressButton

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        val button = findViewById<CircularProgressButton>(R.id.buttonTest)

        button.setOnClickListener {
            button.morphDoneAndRevert(this)
        }
    }
}

private fun defaultColor(context: Context) = ContextCompat.getColor(context, android.R.color.black)

private fun defaultDoneImage(resources: Resources) =
    BitmapFactory.decodeResource(resources, io.pinankh.loadingbutton.R.drawable.ic_done_white_48dp)

private fun ProgressButton.morphDoneAndRevert(
    context: Context,
    fillColor: Int = defaultColor(context),
    bitmap: Bitmap = defaultDoneImage(context.resources),
    doneTime: Long = 3000,
    revertTime: Long = 4000
) {
    progressType = ProgressType.INDETERMINATE
    startAnimation()
    Handler().run {
        postDelayed({ doneLoadingAnimation(fillColor, bitmap) }, doneTime)
        postDelayed(::revertAnimation, revertTime)
    }
}
