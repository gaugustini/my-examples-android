package com.gaugustini.myexamples.implicitintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.BuildConfig
import com.gaugustini.myexamples.databinding.FragmentImplicitIntentBinding
import java.io.File

class ImplicitIntentFragment : Fragment() {

    private lateinit var imageUri: Uri
    private var _binding: FragmentImplicitIntentBinding? = null
    private val binding get() = _binding!!

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            binding.image.setImageURI(imageUri)
            send(imageUri)
        }
    }
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.image.setImageURI(it)
        if (it != null) send(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImplicitIntentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonChoose.setOnClickListener {
            getContent.launch("image/*")
        }
        binding.buttonTakePicture.setOnClickListener {
            imageUri = getTmpFileUri()
            takePicture.launch(imageUri)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getTmpFileUri(): Uri {
        val tmpFile = File.createTempFile("IMG_", ".jpg")

        return FileProvider.getUriForFile(
            requireContext(),
            "${BuildConfig.APPLICATION_ID}.provider",
            tmpFile
        )
    }

    private fun send(uri: Uri) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, uri)
            type = "image/*"
        }
        try {
            startActivity(Intent.createChooser(intent, null))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
        }
    }

}
