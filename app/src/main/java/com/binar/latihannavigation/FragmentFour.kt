package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.binar.latihannavigation.databinding.FragmentFourBinding

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
            val gajiOrtu = binding.etGajiOrtu.text.toString().toInt()
            val penghasilan = binding.etPenghasilan.text.toString().toInt()
            val tanggungan = binding.etTanggungan.text.toString().toInt()

            val dataInputEmpat = FragmenInputEmpat(gajiOrtu, penghasilan, tanggungan) //Parcelable
            val bundle = bundleOf(
                DATAEMPAT to dataInputEmpat //Ngirim Bundle
            )
            findNavController().navigate(R.id.action_fragmentFour_to_fragmentThree, bundle)

        }
    }


}