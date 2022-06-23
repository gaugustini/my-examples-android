package com.gaugustini.myexamples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.gaugustini.myexamples.databinding.ActivityMainBinding
import okio.IOException
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TodoAdapter()
        binding.recyclerViewTodo.adapter = adapter

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Toast.makeText(this@MainActivity, "IOException", Toast.LENGTH_LONG).show()
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Toast.makeText(this@MainActivity, "HttpException", Toast.LENGTH_LONG).show()
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                adapter.submitList(response.body())
            } else {
                Toast.makeText(this@MainActivity, "Response not successful", Toast.LENGTH_LONG)
                    .show()
            }
            binding.progressBar.isVisible = false
        }
    }

}
