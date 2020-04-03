package com.yuval.noisemaker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

class Cell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.cell, this)
        setOnClickListener { onClick() }
    }

    private fun onClick() {
        findViewById<View>(R.id.square).setBackgroundColor(0xffff0000.toInt())
    }
}