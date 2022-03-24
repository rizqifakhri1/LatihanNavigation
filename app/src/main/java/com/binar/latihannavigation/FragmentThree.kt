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

    //Insiasi Binding dan saveArgs
    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!
    val args : FragmentThreeArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment - Diganti dengan binding
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Memampulkan data aName
        val aName = args.name
        binding.tvNama.text = aName

        val terimaData = args.data

        // Apabila tidak null makan akan memperoses stament algoritman berikut
        if (terimaData != null){
            //Menerima data untuk di olah rumus beasiswa
            val gajiOrtu = terimaData.gajiOrtu.toString().toInt()
            val penghasilan = terimaData.penghasilan.toString().toInt()
            val tanggungan = terimaData.tanggungan.toString().toInt()

            //Rumus Beasiswa
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

            //Menampilkan data ke komponen
            binding.tvDescHasil.text = "Berdasarkan data yang telah kamu input sebelumnya, kamu mendapatkan :"
            binding.tvShowGajiOrtu.text = "Gaji Orang Tua : $gajiOrtu"
            binding.tvShowPenghasilan.text = "Penghasilan Pribadi : $penghasilan"
            binding.tvShowTanggungan.text = "Banyak Tanggungan : $tanggungan"
            binding.btnFragmentKeempat.visibility = View.GONE
            binding.ivBinardua.visibility = View.GONE
            binding.ivSabrinaDua.visibility = View.VISIBLE
            binding.ivBgPurple.visibility = View.VISIBLE
        }

        //Fungis untuk mengirim data dari btn fragment tiga ke empat (nama bindingnya btnFragmentKeempat)
        binding.btnFragmentKeempat.setOnClickListener{
            val actionToFragmentThree =
                FragmentThreeDirections.actionFragmentThreeToFragmentFour(aName)
            view.findNavController().navigate(actionToFragmentThree)
            /*findNavController().navigate(R.id.action_fragmentThree_to_fragmentFour)*/
        }
    }

    //Membuat fun onDestroy
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}