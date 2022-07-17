package emo.barkote.emoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import emo.barkote.emoji.databinding.FragmentSplashScreeenBinding


class SplashScreen : Fragment() {

    private lateinit var binding: FragmentSplashScreeenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
       binding = FragmentSplashScreeenBinding.inflate(inflater,container,false)





        return binding.root
    }



}