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
        createGrid()
    }

    private fun createGrid() {
        val grid = findViewById<LinearLayout>(R.id.grid_container)
        for (x in 1..8) {
            val line = LinearLayout(this)
            line.orientation = LinearLayout.HORIZONTAL
            line.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            for (y in 1..8) {
                val square = Cell(this)
                square.layoutParams = LinearLayout.LayoutParams(0, 200, 1F)
                line.addView(square)
            }
            grid.addView(line)
        }
    }
}