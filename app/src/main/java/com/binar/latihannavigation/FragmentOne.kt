package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binar.latihannavigation.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    // Inisiasi Binding
    private var _binding : FragmentOneBinding? = null
    private val binding get() = _binding!!

    // Membuat Companion object untuk bundle
    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }

    // Default
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment - Diganti dengan binding
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return  binding.root
    }

    // Buat fun onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Inisiasi Binding pada Button Fragmetn Kedua untuk mengirim bundle
        binding.btnFragmentKedua.setOnClickListener{
            val mBundle = Bundle ()
            mBundle.putString(EXTRA_NAME, "Binarian Pertama")
            it.findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, mBundle) //Mengirimkan Data ke fragment ke dua
        }
    }

    // Buat fun onDestroy
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}