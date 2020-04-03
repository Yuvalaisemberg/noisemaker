package com.yuval.noisemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Sound.init(this)

        createGrid()
    }

    private fun createGrid() {
        val grid = findViewById<LinearLayout>(R.id.grid_container)
        for (x in 0..7) {
            val line = LinearLayout(this)
            line.orientation = LinearLayout.HORIZONTAL
            line.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            for (y in 1..8) {
                val cell = Cell(this)
                cell.index = x
                cell.layoutParams = LinearLayout.LayoutParams(0, 200, 1F)
                line.addView(cell)
            }
            grid.addView(line)
        }
    }
}