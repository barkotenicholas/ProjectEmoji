package emo.barkote.emoji

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import emo.barkote.emoji.databinding.FragmentSplashScreeenBinding


class SplashScreen : Fragment() {

    private lateinit var binding: FragmentSplashScreeenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreeenBinding.inflate(inflater, container, false)


        Handler(Looper.getMainLooper()).postDelayed({
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.action_splashScreen_to_emoji, null,
                navOptions { // Use the Kotlin DSL for building NavOptions
                    anim {
                        enter = android.R.animator.fade_in
                        exit = android.R.animator.fade_out
                    }
                })
        }, 3000)
        return binding.root
    }


}