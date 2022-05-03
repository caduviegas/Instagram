package com.innaval.instagram.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.innaval.instagram.R
import com.innaval.instagram.commom.view.CustomDialog
import com.innaval.instagram.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment() {

    private  var binding: FragmentRegisterPhotoBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterPhotoBinding.bind(view)



        val customDialog = CustomDialog(requireContext())

        customDialog.addButton(R.string.photo, R.string.gallery) {
            when (it.id) {
                R.string.photo -> {
                    Log.i("Teste", "foto")
                    //Agora é possivel Abrir a camera
                }
                R.string.gallery -> {
                    Log.i("Teste", "galeria")
                    // Agora é possivel abrir a galeria
                }
            }
        }

        customDialog.show()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}