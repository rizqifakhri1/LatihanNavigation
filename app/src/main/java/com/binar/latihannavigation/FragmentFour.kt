package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.binar.latihannavigation.databinding.FragmentFourBinding
import com.binar.latihannavigation.databinding.FragmentOneBinding

class FragmentFour : Fragment() {

    companion object {
        val DATAEMPAT = "DATAEMPAT" //Kunci untuk mecocokan pengiriman (Nomer Resi)
    }

    private var _binding : FragmentFourBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFragmentEmpat.setOnClickListener{
            val usia = binding.etUsia.text.toString().toInt()
            val alamat = binding.etAlamat.text.toString()
            val pekerjaan = binding.etPekerjaan.text.toString()

            val dataInputEmpat = FragmenInputEmpat(usia, alamat, pekerjaan) //Parcelable
            val bundle = bundleOf(
                DATAEMPAT to dataInputEmpat //Ngirim Bundle
            )
            findNavController().navigate(R.id.action_fragmentFour_to_fragmentThree, bundle)

        }
    }


}