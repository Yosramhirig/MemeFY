package com.example.memefy.ui.meme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import com.example.memefy.Model.Getmemes.MySharedPref
import com.example.memefy.R
import com.example.memefy.databinding.FragmentMemeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemeFragment : Fragment(R.layout.fragment_meme) {
    private var _binding: FragmentMemeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MemeViewModel by viewModels()
    private val viewModel2: MemeViewModel2 by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMemeBinding.bind(view)
        var pref =  MySharedPref(requireContext())
        if(pref.getUsername() == 1){
            viewModel.memes.observe(viewLifecycleOwner) { meme ->

                binding.subreddit.text = meme.subreddit
                binding.memeimg.load(meme.url)

            }
        }else{
            viewModel2.memes.observe(viewLifecycleOwner) { meme ->

                binding.subreddit.text = meme.subreddit
                binding.memeimg.load(meme.url)
        }

    }}



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}