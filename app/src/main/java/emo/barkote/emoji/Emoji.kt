package emo.barkote.emoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import emo.barkote.emoji.databinding.FragmentEmojiBinding

class Emoji : Fragment() {

    private lateinit var binding: FragmentEmojiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEmojiBinding.inflate(inflater,container,false)



        return binding.root
    }

}