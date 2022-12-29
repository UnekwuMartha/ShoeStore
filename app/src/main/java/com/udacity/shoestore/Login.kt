package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //declare and initialize binding object to use login binding class, and inflate the correct layout
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        //set sign in button to navigate to correct fragment
        binding.signin.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToWelcome())
        }

        //set sign up button to navigate to correct fragment
        binding.signup.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToWelcome())
        }
        return binding.root
    }
}