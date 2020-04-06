package com.yuval.noisemaker

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class Column @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val cells: MutableList<Cell> = mutableListOf()

    init {
        orientation = LinearLayout.VERTICAL
        layoutParams = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            1F
        )
    }

    fun addCell(cell: Cell) {
        addView(cell)
        cells.add(cell)
    }

    fun play() {
        setBackgroundColor(0x44ffff00.toInt())
    }
}