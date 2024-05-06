package com.example.bignumber

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.annotation.SuppressLint
import androidx.activity.enableEdgeToEdge
import android.widget.Toast
import kotlin.random.Random
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var leftBtn: Button
    private lateinit var rightBtn: Button

    private var point = 0
    private var round = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftBtn = findViewById(R.id.leftBtn)
        rightBtn = findViewById(R.id.rightBtn)

        leftBtn.setOnClickListener { onLeftButtonClick() }
        rightBtn.setOnClickListener { onRightButtonClick() }

        nextRound()
    }

    private fun randomNumbers(): Pair<Int, Int> {
        val leftVal = (1..100).random()
        val rightVal = (1..100).random()
        return Pair(leftVal, rightVal)
    }

    private fun updateButtons(leftVal: Int, rightVal: Int) {
        leftBtn.text = leftVal.toString()
        rightBtn.text = rightVal.toString()
    }

    private fun onLeftButtonClick() {
        val leftVal = leftBtn.text.toString().toInt()
        val rightVal = rightBtn.text.toString().toInt()

        if (leftVal > rightVal) {
            point++
        }

        nextRound()
    }

    private fun onRightButtonClick() {
        val leftVal = leftBtn.text.toString().toInt()
        val rightVal = rightBtn.text.toString().toInt()

        if (rightVal > leftVal) {
            point++
        }

        nextRound()
    }

    private fun nextRound() {
        round++
        if (round <= 10) {
            val (leftVal, rightVal) = randomNumbers()
            updateButtons(leftVal, rightVal)
        } else {
            showScore()
        }
    }

    private fun showScore() {
        Toast.makeText(this, "Your score is: $point", Toast.LENGTH_LONG).show()
        // Reset the game if needed
        // point = 0
        // round = 0
    }
}
