package emo.barkote.emoji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import emo.barkote.emoji.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFrag = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        val navController = navHostFrag.navController




    }
}