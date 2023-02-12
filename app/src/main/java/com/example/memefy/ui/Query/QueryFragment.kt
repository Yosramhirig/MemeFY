package com.example.memefy.ui.Query

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.memefy.Model.Getmemes.MySharedPref
import com.example.memefy.R
import com.example.memefy.databinding.FragmentQueryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QueryFragment : Fragment(R.layout.fragment_query) {
    private var _binding: FragmentQueryBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentQueryBinding.bind(view)

        binding.apply {
            binding.btSubmit.setOnClickListener() {

                var x : Int = 0
                var y : Int = 0

                if(rbCats.isChecked){
                    x += 1
                }
                if(rbYes.isChecked){
                    x+= 1
                }
                if(rbPotatoes.isChecked){
                    x+= 1
                }
                if(rbDogs.isChecked){
                    y +=1
                }
                if(rbNo.isChecked){
                    y += 1
                }
                if(rbRg.isChecked){
                    y +=1
                }

                if((rbDogs.isChecked || rbCats.isChecked) && (rbYes.isChecked || rbNo.isChecked) && (rbPotatoes.isChecked || rbRg.isChecked )){
                    Toast.makeText(requireContext(), y.toString(), Toast.LENGTH_SHORT).show()
                    val pref = MySharedPref(requireContext())
                    if(x > y){
                        pref.saveUsername(1)
                    }else{
                        pref.saveUsername(2)
                    }
                    val action = QueryFragmentDirections.actionQueryFragmentToMemeFragment()
                    findNavController().navigate(action)
                }else{
                    Toast.makeText(requireContext(), "Please answer all the questions!!!!", Toast.LENGTH_SHORT).show()
                }




            }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}