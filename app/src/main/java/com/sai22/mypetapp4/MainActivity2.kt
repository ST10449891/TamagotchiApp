package com.sai22.mypetapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat

class MainActivity2 : AppCompatActivity() {
    private var petHealth = 100
    private var petHunger = 100
    private var petCleanliness = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Set buttons and text views
        val feedButton = findViewById<Button>(R.id.feedButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val healthTextView = findViewById<TextView>(R.id.healthTextView)
        val hungerTextView = findViewById<TextView>(R.id.hungerTextView)
        val cleanTextView = findViewById<TextView>(R.id.cleanTextView)
        val petImage = findViewById<ImageView>(R.id.petImage)

        // Set initial text values
        healthTextView.text = petHealth.toString()
        hungerTextView.text = petHunger.toString()
        cleanTextView.text = petCleanliness.toString()

        // Handle button clicks
        feedButton.setOnClickListener {
            petHunger += 10
            petHealth += 0
            petCleanliness += 0
            healthTextView.text = petHealth.toString()
            hungerTextView.text = petHunger.toString()
            cleanTextView.text = petCleanliness.toString()
            animateimageChange(petImage, R.drawable.img_3)
        }

        cleanButton.setOnClickListener {
            petCleanliness += 10
            petHealth += 10
            healthTextView.text = petHealth.toString()
            animateimageChange(petImage, R.drawable.img_2)
        }

        playButton.setOnClickListener {
            petHunger -= 5
            petCleanliness -= 5
            petHealth += 0
            hungerTextView.text = petHunger.toString()
            cleanTextView.text = petCleanliness.toString()
            animateimageChange(petImage, R.drawable.img_1)
        }
    }

    private val handler = Handler(Looper.getMainLooper())
    private val originalImageResource = R.drawable.dog // Assuming petImage is the default image resource

    private fun animateimageChange(petImage: ImageView?, imageResource: Int) {
        petImage?.setImageResource(imageResource)
        handler.postDelayed({
            petImage?.setImageResource(originalImageResource)
        }, 3000) // Change 3000 to the desired delay in milliseconds (e.g., 3000 for 3 seconds)
    }
}