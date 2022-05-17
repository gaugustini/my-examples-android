package com.gaugustini.myexamples.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gaugustini.myexamples.R
import com.gaugustini.myexamples.databinding.ActivityExampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = intent.getIntExtra("EXTRA_RANDOM", 0)
        binding.textView.text = getString(R.string.activity_text, number)
    }

}
