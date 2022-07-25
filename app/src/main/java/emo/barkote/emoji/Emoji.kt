package emo.barkote.emoji

import android.content.DialogInterface
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import emo.barkote.emoji.databinding.FragmentEmojiBinding

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



        val lengthFilter = InputFilter.LengthFilter(3)
        binding.emojiInput.filters = arrayOf(EmojiFilter(),lengthFilter)

        binding.button.setOnClickListener{
            if(validateInfo()){

            }
        }

        return binding.root
    }

    private fun validateInfo(): Boolean {
        val text = binding.emojiInput.text.toString()
        return if(text.isEmpty()){
            binding.emojiInput.error = "Please Input Emoji"
            false
        }else{
            true
        }
    }

    inner class EmojiFilter : InputFilter{
        override fun filter(source: CharSequence?,start: Int,end: Int,dest: Spanned?,dstart: Int,dend: Int): CharSequence {

            if(source ==  null || source.isBlank()){
                return ""
            }

            val validTypes = listOf(Character.SURROGATE,Character.OTHER_SYMBOL,Character.NON_SPACING_MARK).map { it.toInt() }

            for(inputType in source){
              val type =  Character.getType(inputType)

                if(!validTypes.contains(type)){
                    Toast.makeText(context,"Only emojis are allowed ",Toast.LENGTH_SHORT).show()
                    return ""
                }
            }
            return source
        }

    }

}