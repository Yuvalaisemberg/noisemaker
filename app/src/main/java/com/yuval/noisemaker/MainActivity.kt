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
            val square = View(this)
            square.layoutParams = LinearLayout.LayoutParams(55, 50)
            square.setBackgroundColor(0xFFFF0000.toInt())
            grid.addView(square)

        }

    }
}
