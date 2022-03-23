package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.binar.latihannavigation.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {
    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aName = FragmentThreeArgs.fromBundle(arguments as Bundle).name
        binding.tvNama.text = "Namanya : $aName"

        val dataempat = arguments?.getParcelable<FragmenInputEmpat>(FragmentFour.DATAEMPAT)



        if (dataempat != null){
            if (dataempat.usia %2 == 0 ){
                binding.tvUsiaAnda.text = "Usia Anda : Genap"
            }
            else {
                binding.tvUsiaAnda.text = "Usia Anda : Ganjil"
            }
            binding.tvAlamatAnda.text = "Alamat Anda : ${dataempat.alamat}"
            binding.tvPekerjaanAnda.text = "Pekerjaan Anda : ${dataempat.pekerjaan}"
            binding.btnFragmentKeempat.visibility = View.GONE
        }

        binding.btnFragmentKeempat.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentThree_to_fragmentFour)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}