package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binar.latihannavigation.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private var _binding : FragmentOneBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFragmentKedua.setOnClickListener{
            val mBundle = Bundle ()
            mBundle.putString(EXTRA_NAME, "Binarian Pertama")
            it.findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, mBundle) //Mengirimkan Data ke fragment ke dua
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}