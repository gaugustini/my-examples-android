package com.gaugustini.myexamples.ui.implicitintent

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.BuildConfig
import com.gaugustini.myexamples.databinding.FragmentImplicitIntentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class ImplicitIntentFragment : Fragment() {

    private lateinit var binding: FragmentImplicitIntentBinding
    private lateinit var imageUri: Uri

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            binding.image.setImageURI(imageUri)
        }
    }
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.image.setImageURI(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImplicitIntentBinding.inflate(inflater, container, false)
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

    private fun getTmpFileUri(): Uri {
        val tmpFile = File.createTempFile("IMG_", ".jpg").apply {
            createNewFile()
            deleteOnExit()
        }

        return FileProvider.getUriForFile(
            requireContext(),
            "${BuildConfig.APPLICATION_ID}.provider",
            tmpFile
        )
    }

}
