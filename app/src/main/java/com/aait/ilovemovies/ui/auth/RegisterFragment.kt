package com.aait.ilovemovies.ui.auth

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.aait.ilovemovies.R
import com.aait.ilovemovies.databinding.FragmentLoginBinding
import com.aait.ilovemovies.databinding.FragmentRegisterBinding
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import com.sangcomz.fishbun.define.Define

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private var phone = ""
    private var password = ""
    private var passwordConfirmation = ""
    private var lock = false
    private var avatar: Uri? = null
    private val RESULT_PROFILE = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarTitle.text = getString(R.string.register)
        clicks()

        binding.phoneEditText.doOnTextChanged { text, start, before, count ->
            checkLength()
        }

        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
            checkLength()
        }

        binding.confirmPasswordEditText.doOnTextChanged { text, start, before, count ->
            checkLength()
        }

        return binding.root
    }

    private fun clicks() {
        binding.avatarImg.setOnClickListener {
            openGallery()
        }
        binding.changeImg.setOnClickListener {
            openGallery()
        }
        binding.signInTv.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun checkLength() {
        phone = binding.phoneEditText.text.toString()
        password = binding.passwordEditText.text.toString()
        passwordConfirmation = binding.confirmPasswordEditText.text.toString()

        binding.registerBtn.isEnabled = phone.length >= 9 && password.length >= 6 && passwordConfirmation.length >= 6
    }

    private fun openGallery() {
        FishBun.with(this)
            .setImageAdapter(GlideAdapter())
            .setIsUseDetailView(false)
            .setRequestCode(RESULT_PROFILE)
            .setAllViewTitle(getString(R.string.all_images))
            .setMaxCount(1)
            .setMinCount(1)
            .startAlbum()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                RESULT_PROFILE -> {
                    val x: List<Uri> = data.getParcelableArrayListExtra(Define.INTENT_PATH)!!
                    if (x.isNotEmpty()) {
                        avatar = x[0]
                        binding.avatarImg.setImageURI(avatar)
                    }
                }
            }
        }
    }
}