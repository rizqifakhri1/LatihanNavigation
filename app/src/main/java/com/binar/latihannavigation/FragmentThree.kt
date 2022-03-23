package com.binar.latihannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.latihannavigation.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {
    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!
    val args : FragmentThreeArgs by navArgs()

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

        val aName = args.name
        binding.tvNama.text = "Namanya : $aName"

       /* val dataempat = arguments?.getParcelable<FragmenInputEmpat>(FragmentFour.DATAEMPAT)*/

        val terimaData = args.data

        if (terimaData != null){

            val gajiOrtu = terimaData.gajiOrtu.toString().toInt()
            val penghasilan = terimaData.penghasilan.toString().toInt()
            val tanggungan = terimaData.tanggungan.toString().toInt()

            //Rumus
            var count = (gajiOrtu + penghasilan)/ tanggungan
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

            binding.tvShowGajiOrtu.text = "Gaji Ortu : ${gajiOrtu}"
            binding.tvShowPenghasilan.text = "Alamat Anda : ${penghasilan}"
            binding.tvShowTanggungan.text = "Pekerjaan Anda : ${tanggungan}"
            binding.btnFragmentKeempat.visibility = View.GONE
        }

        binding.btnFragmentKeempat.setOnClickListener{
            val actionToFragmentThree =
                FragmentThreeDirections.actionFragmentThreeToFragmentFour(aName)
            view.findNavController().navigate(actionToFragmentThree)
            /*findNavController().navigate(R.id.action_fragmentThree_to_fragmentFour)*/
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}