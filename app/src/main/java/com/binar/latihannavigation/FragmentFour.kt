package com.binar.latihannavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.latihannavigation.databinding.FragmentFourBinding

class FragmentFour : Fragment() {

    //Membuat companion object
/*    companion object {
        val DATAEMPAT = "DATAEMPAT" //Kunci untuk mecocokan pengiriman (Nomer Resi)
    }*/

    //Insiasi binding pada fragment dan juga saveArgs
    private var _binding : FragmentFourBinding? = null
    private val binding get() = _binding!!
    val args: FragmentFourArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment -> menganti isinya dengen binding
        _binding = FragmentFourBinding.inflate(inflater, container, false)
        return  binding.root
    }

    // Membuat fun onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Binding btn fragment Empat untuk mengirim data
        binding.btnFragmentEmpat.setOnClickListener{

            //Inisiasi variabel
            val gajiOrtu = binding.etGajiOrtu.text.toString().toInt()
            val penghasilan = binding.etPenghasilan.text.toString().toInt()
            val tanggungan =  binding.etTanggungan.text.toString().toInt()

            //Insiasi variabel atas menjadi satu dan mengirimkan ke class FragmentInputEmpat
            val dataInputEmpat = FragmenInputEmpat(
                gajiOrtu, penghasilan, tanggungan
            )

            //Mengimkan data
            val dataKirim = FragmentFourDirections.actionFragmentFourToFragmentThree(args.nameName, dataInputEmpat)
            it.findNavController().navigate(dataKirim)

        }
    }


}