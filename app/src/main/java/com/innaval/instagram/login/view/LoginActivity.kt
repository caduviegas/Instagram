package com.innaval.instagram.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.innaval.instagram.R
import com.innaval.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            binding.loginEditEmail.addTextChangedListener(watcher)
            binding.loginEditPassword.addTextChangedListener(watcher)

            binding.loginBtnEnter.setOnClickListener {
                binding.loginBtnEnter.showProgress(true)


                binding.loginEditEmailInput.error = "Esse e-mail é inválido"
                binding.loginEditPasswordInput.error = "Senha Incorreta"


                Handler(Looper.getMainLooper()).postDelayed({
                    binding.loginBtnEnter.showProgress(false)
                }, 2000)
            }
        }
    }


    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.loginBtnEnter.isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

}