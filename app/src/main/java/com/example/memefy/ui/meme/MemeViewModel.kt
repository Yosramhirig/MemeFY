package com.example.memefy.ui.meme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memefy.Model.Getmemes.Getsmemes
import com.example.memefy.Model.Getmemes.MemesApi
import com.example.memefy.Model.Getmemes.MemesApiImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemeViewModel  @Inject constructor(private val memeapi: MemesApiImp ): ViewModel() {
//    private var postsApi: MemesApi = MemesApiImp(Provider.client)
    private val _memes: MutableLiveData<Getsmemes> = MutableLiveData()
    val memes: LiveData<Getsmemes> get() = _memes

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _memes.value = memeapi.getMemes()
        }
    }
}