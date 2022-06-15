package com.gaugustini.myexamples.ui.datastore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.gaugustini.myexamples.databinding.FragmentDataStoreBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreFragment : Fragment() {

    private lateinit var binding: FragmentDataStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonSave.setOnClickListener {
            lifecycleScope.launch {
                save(
                    key = binding.editTextKey.text.toString(),
                    value = binding.editTextValue.text.toString()
                )
            }
        }
        binding.buttonRead.setOnClickListener {
            lifecycleScope.launch {
                val value = read(key = binding.editTextKeySaved.text.toString())
                binding.textValueSaved.text = value ?: "No value found"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

    private suspend fun save(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        requireContext().dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    private suspend fun read(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = requireContext().dataStore.data.first()
        return preferences[dataStoreKey]
    }

}
