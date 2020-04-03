package com.yuval.noisemaker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

class Cell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var state: CellState = CellState.Off
    var index: Int = 0

    init {
        inflate(context, R.layout.cell, this)
        setOnClickListener { onClick() }
    }

    private fun onClick() {
        state = if (state == CellState.Off) CellState.On else CellState.Off

        refreshState()
        if (state==CellState.On) {
            play()
        }
    }

    private fun refreshState() {
        val color = when (state) {
            CellState.On -> 0xffff0000.toInt()
            CellState.Off -> 0xffeeeeee.toInt()
        }
        findViewById<View>(R.id.square).setBackgroundColor(color)

    }

    private fun play() {
        when (index) {
            0 -> Sound.play(context, Sound.SoundFile.a_0)
            1 -> Sound.play(context, Sound.SoundFile.a_1)
            2 -> Sound.play(context, Sound.SoundFile.a_2)
            3 -> Sound.play(context, Sound.SoundFile.a_3)
            4 -> Sound.play(context, Sound.SoundFile.a_4)
            5 -> Sound.play(context, Sound.SoundFile.a_5)
            6 -> Sound.play(context, Sound.SoundFile.a_6)
            7 -> Sound.play(context, Sound.SoundFile.a_7)
        }
    }

    enum class CellState {
        On,
        Off
    }
}