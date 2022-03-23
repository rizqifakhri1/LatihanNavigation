package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
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
            var count = (dataempat.gajiOrtu + dataempat.penghasilan)/ dataempat.tanggungan
            if (count <= 100000){
                binding.tvHasil.text = "Beasiswa Gratis"
            }
            else if (count in 100000..250000){
                binding.tvHasil.text = "Potongan Rp. 2.000.000"
            }
            else if (count in 250001..500000){
                binding.tvHasil.text = "Potongan Rp. 1.000.000"
            }
            else if (count in 500001..750000){
                binding.tvHasil.text = "Potongan Rp. 500.000"
            }
            else if (count in 750001..1000000){
                binding.tvHasil.text = "Potongan Rp. 250.000"
            }
            else {
                binding.tvHasil.text = "Mohon maaf anda tidak bisa menerima beasiswa"
            }

            binding.tvShowGajiOrtu.text = "Gaji Ortu : ${dataempat.gajiOrtu}"
            binding.tvShowPenghasilan.text = "Alamat Anda : ${dataempat.penghasilan}"
            binding.tvShowTanggungan.text = "Pekerjaan Anda : ${dataempat.tanggungan}"
            binding.btnFragmentKeempat.visibility = View.GONE
        }

        binding.btnFragmentKeempat.setOnClickListener{
            val actionToFragmentThree =
                FragmentThreeDirections.actionFragmentThreeToFragmentFour()
            actionToFragmentThree.name = aName.toString()
            view.findNavController().navigate(actionToFragmentThree)
            /*findNavController().navigate(R.id.action_fragmentThree_to_fragmentFour)*/
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}