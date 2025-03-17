package io.pinankh.loadingbutton

/**
 * Created by @Author Pinankh Patel on 10,March,2025
 * Mobile App Developer,
 * Gujarat, INDIA.
 */

import android.animation.Animator
import android.view.View

internal fun Animator.disposeAnimator() {
    end()
    removeAllListeners()
    cancel()
}

internal fun View.updateWidth(width: Int) {
    val layoutParams = this.layoutParams
    layoutParams.width = width
    this.layoutParams = layoutParams
}

internal fun View.updateHeight(height: Int) {
    val layoutParams = this.layoutParams
    layoutParams.height = height
    this.layoutParams = layoutParams
}
