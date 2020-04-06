package com.yuval.noisemaker

import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children

class MainActivity : AppCompatActivity() {
    private var currentColumn = 0
    private val columns: MutableList<Column> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createGrid()
        startPlaying()
    }

    private fun createGrid() {
        val grid = findViewById<LinearLayout>(R.id.grid_container)
        for (x in 0..7) {
            val column = Column(this)

            for (y in 1..14) {
                val cell = Cell(this)
                cell.index = y
                cell.layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 120)
                column.addCell(cell)
            }
            grid.addView(column)
            columns.add(column)
        }
    }

    private fun startPlaying() {
        Handler().postDelayed({
            playColumn(currentColumn)
            currentColumn += 1
            if (currentColumn == 8) {
                currentColumn = 0
            }
            startPlaying()
        }, 500)

    }

    private fun playColumn(index: Int) {
        columns[index].play()
        for (x in 0..7) {
            if (x != index) {
                columns[x].reset()

            }
        }
    }
}