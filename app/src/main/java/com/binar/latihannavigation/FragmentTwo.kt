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
    // Inisiasi Binding
    private var _binding : FragmentTwoBinding? = null
    private val binding get() = _binding!!

    //Default
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment - Diganti dengan binding
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Buat fun onViewCreaated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Inisiasi Binding ke button fragment tiga untuk mengirimkan data
        binding.btnFragmentKetiga.setOnClickListener{
            //Logika untuk tidak memperbolehkan form nama kosong
            if (binding.etName.text.isNullOrEmpty()){
                //Menampilkan Toast
                Toast.makeText(requireContext(), "Kolom Nama Masih Kosong", Toast.LENGTH_SHORT).show()
            }
            else {
                val actionToFragmentThree =
                    //Mengirimkan data etNama
                    FragmentTwoDirections.actionFragmentTwoToFragmentThree(binding.etName.text.toString(), null)
                view.findNavController().navigate(actionToFragmentThree)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}