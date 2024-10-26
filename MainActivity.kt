package com.example.uploadimage1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView

    private lateinit var selectImageBtn1: Button
    private lateinit var selectImageBtn2: Button
    private lateinit var selectImageBtn3: Button
    private lateinit var selectImageBtn4: Button
    private lateinit var selectImageBtn5: Button

    companion object {
        const val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ImageViews
        imageView1 = findViewById(R.id.imageSearch1)
        imageView2 = findViewById(R.id.imageSearch2)
        imageView3 = findViewById(R.id.imageSearch3)
        imageView4 = findViewById(R.id.imageSearch4)
        imageView5 = findViewById(R.id.imageSearch5)

        // Initialize Buttons
        selectImageBtn1 = findViewById(R.id.selectImageBtn1)
        selectImageBtn2 = findViewById(R.id.selectImageBtn2)
        selectImageBtn3 = findViewById(R.id.selectImageBtn3)
        selectImageBtn4 = findViewById(R.id.selectImageBtn4)
        selectImageBtn5 = findViewById(R.id.selectImageBtn5)

        // Set click listeners for each button
        selectImageBtn1.setOnClickListener { pickImageGallery(1) }
        selectImageBtn2.setOnClickListener { pickImageGallery(2) }
        selectImageBtn3.setOnClickListener { pickImageGallery(3) }
        selectImageBtn4.setOnClickListener { pickImageGallery(4) }
        selectImageBtn5.setOnClickListener { pickImageGallery(5) }
    }

    private fun pickImageGallery(imageNumber: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, imageNumber)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                1 -> imageView1.setImageURI(data?.data)
                2 -> imageView2.setImageURI(data?.data)
                3 -> imageView3.setImageURI(data?.data)
                4 -> imageView4.setImageURI(data?.data)
                5 -> imageView5.setImageURI(data?.data)
            }
        }
    }
}