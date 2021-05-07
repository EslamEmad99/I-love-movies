package com.aait.ilovemovies.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.aait.ilovemovies.R
import com.aait.ilovemovies.databinding.FragmentLoginBinding
import com.aait.ilovemovies.ui.home.MainActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var phone = ""
    private var password = ""
    private var lock = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.toolbar.arrBack.visibility = View.GONE
        binding.toolbar.toolbarTitle.text = getString(R.string.login)
        clicks()

        binding.phoneEditText.doOnTextChanged { text, start, before, count ->
            checkLength()
        }

        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
            checkLength()
        }
        return binding.root
    }

    private fun clicks() {
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
        binding.signUpTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun checkLength() {
        phone = binding.phoneEditText.text.toString()
        password = binding.passwordEditText.text.toString()

        binding.loginBtn.isEnabled = phone.length >= 9 && password.length >= 6
    }
}