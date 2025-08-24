package com.example.myapplicationv2

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redInput = findViewById<EditText>(R.id.redInput)
        val greenInput = findViewById<EditText>(R.id.greenInput)
        val blueInput = findViewById<EditText>(R.id.blueInput)
        val createColorButton = findViewById<Button>(R.id.createColorButton)
        val colorPanel = findViewById<View>(R.id.colorPanel)

        createColorButton.setOnClickListener {
            val redHex = redInput.text.toString()
            val greenHex = greenInput.text.toString()
            val blueHex = blueInput.text.toString()

            if (redHex.length == 2 && greenHex.length == 2 && blueHex.length == 2 &&
                redHex.matches(Regex("[0-9a-fA-F]{2}")) &&
                greenHex.matches(Regex("[0-9a-fA-F]{2}")) &&
                blueHex.matches(Regex("[0-9a-fA-F]{2}"))
            ) {
                try {
                    val color = "#$redHex$greenHex$blueHex".toColorInt()
                    colorPanel.setBackgroundColor(color)
                } catch (e: Exception) {
                    Toast.makeText(this, "Invalid color format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter valid 2-digit hex for each channel", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
