package com.example.pb2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.example.pb2.databinding.ActivityDisplayBinding
import java.io.File

class DisplayActivity : AppCompatActivity() {
    private var _binding: ActivityDisplayBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        _binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        val image_url: String = intent.getStringExtra("saved_image_url").toString()

        val imgFile = File("${Environment.getExternalStorageDirectory()}/${image_url}")
        val myBitmap = BitmapFactory.decodeFile((imgFile.absolutePath))

        binding.ImgFoto.setImageBitmap(myBitmap)

        binding.TVStyle.text = intent.getStringExtra("style")
        binding.TVHarga.text = intent.getStringExtra("harga")
        binding.TVLamaPotong.text = intent.getStringExtra("lama_potong")
    }
}