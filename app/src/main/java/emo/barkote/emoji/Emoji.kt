package emo.barkote.emoji

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import emo.barkote.emoji.databinding.FragmentEmojiBinding
import kotlinx.coroutines.NonCancellable.cancel

class Emoji : Fragment() {

    private lateinit var binding: FragmentEmojiBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback (true){
                override fun handleOnBackPressed() {

                    val alertDialog: AlertDialog? = activity?.let {
                        val builder = AlertDialog.Builder(it)

                        builder.apply {
                            setPositiveButton(R.string.ok,
                                DialogInterface.OnClickListener { _, _ ->
                                    requireActivity().finish()
                                })
                            setNegativeButton(R.string.cancel,
                                DialogInterface.OnClickListener { dialog, _ ->
                                    dialog.cancel()
                                })
                        }

                        builder.setTitle("Exit")
                        builder.setMessage("Do you want to exit")
                        builder.create()
                    }

                    alertDialog!!.show()

                }

            })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEmojiBinding.inflate(inflater,container,false)




        return binding.root
    }

}