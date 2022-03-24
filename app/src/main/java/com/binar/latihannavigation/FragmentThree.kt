package com.binar.latihannavigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.latihannavigation.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {
    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!
    val args : FragmentThreeArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aName = args.name
        binding.tvNama.text = aName
/*        binding.tvHasil.visibility = View.GONE*/
/*        binding.ivBgHasil.visibility = View.GONE*/


       /* val dataempat = arguments?.getParcelable<FragmenInputEmpat>(FragmentFour.DATAEMPAT)*/

        val terimaData = args.data

        if (terimaData != null){

            val gajiOrtu = terimaData.gajiOrtu.toString().toInt()
            val penghasilan = terimaData.penghasilan.toString().toInt()
            val tanggungan = terimaData.tanggungan.toString().toInt()

            //Rumus
            val count = (gajiOrtu + penghasilan)/ tanggungan
            if (count <= 100000){
                binding.tvHasil.text = "Beasiswa Gratis"
                binding.tvHasil.visibility = View.VISIBLE
            }
            else if (count in 100000..250000){
                binding.tvHasil.text = "Potongan Rp. 2.000.000"
                binding.tvHasil.visibility = View.VISIBLE
            }
            else if (count in 250001..500000){
                binding.tvHasil.text = "Potongan Rp. 1.000.000"
                binding.tvHasil.visibility = View.VISIBLE
            }
            else if (count in 500001..750000){
                binding.tvHasil.text = "Potongan Rp. 500.000"
                binding.tvHasil.visibility = View.VISIBLE
            }
            else if (count in 750001..1000000){
                binding.tvHasil.text = "Potongan Rp. 250.000"
                binding.tvHasil.visibility = View.VISIBLE
            }
            else {
                binding.tvHasil.text = "Mohon maaf anda tidak bisa menerima beasiswa"
                binding.tvHasil.visibility = View.VISIBLE
            }
/*            binding.ivBgHasil.visibility = View.VISIBLE*/
            binding.tvDescHasil.text = "Berdasarkan data yang telah kamu input sebelumnya, kamu mendapatkan :"
            binding.tvShowGajiOrtu.text = "Gaji Orang Tua : $gajiOrtu"
            binding.tvShowPenghasilan.text = "Penghasilan Pribadi : $penghasilan"
            binding.tvShowTanggungan.text = "Banyak Tanggungan : $tanggungan"
            binding.btnFragmentKeempat.visibility = View.GONE
            binding.ivBinardua.visibility = View.GONE
            binding.ivSabrinaDua.visibility = View.VISIBLE
            binding.ivBgPurple.visibility = View.VISIBLE
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