package com.yuval.noisemaker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Cell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var state: CellState = CellState.Off
    var index: Int = 0

    init {
        inflate(context, R.layout.cell, this)
        setOnClickListener { onClick() }
    }

    private fun onClick() {
        state = if (state == CellState.Off) CellState.On else CellState.Off

        refreshState()
    }

    private fun refreshState() {
        val color = when (state) {
            CellState.On -> 0xffff0000.toInt()
            CellState.Off -> 0xffeeeeee.toInt()
        }
        findViewById<View>(R.id.square).setBackgroundColor(color)
    }

    fun play() {
        Sound.play(context, index)
    }

    enum class CellState {
        On,
        Off
    }
}