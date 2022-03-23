package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.binar.latihannavigation.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    private var _binding : FragmentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFragmentKetiga.setOnClickListener{  view ->
            if (binding.etName.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom Nama Masih Kosong", Toast.LENGTH_SHORT).show()
            }
            else {
                val actionToFragmentThree =
                    FragmentTwoDirections.actionFragmentTwoToFragmentThree()
                actionToFragmentThree.name = binding.etName.text.toString()
                view.findNavController().navigate(actionToFragmentThree)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}