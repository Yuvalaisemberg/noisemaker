package com.yuval.noisemaker

import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var currentColumn = 0
    private var currentLoop = 0
    private val columns: MutableList<Column> = mutableListOf()
    private val autoPilotCells: MutableList<Cell> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createGrid()
        findViewById<Switch>(R.id.auto_pilot).setOnCheckedChangeListener { buttonView, isChecked ->
            toggleAutoPilot(isChecked)
        }
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
                currentLoop += 1
                if (currentLoop == 2) {
                    currentLoop = 0
                    toggleRandomCell()
                }
            }
            startPlaying()
        }, 100)
    }

    private fun playColumn(index: Int) {
        columns[index].play()
        for (x in 0..7) {
            if (x != index) {
                columns[x].reset()

            }
        }
    }

    private fun toggleAutoPilot(isChecked: Boolean) {

    }

    private fun toggleRandomCell() {
        val column = columns[(0..columns.size - 1).random()]
        val cell = column.getRandomCell()
        autoPilotCells.add(cell)
        cell.on()
        if (autoPilotCells.size > 10) {
            val oldestCell = autoPilotCells[0]
            oldestCell.off()
            autoPilotCells.removeAt(0)
        }
    }
}