package com.fantasma.receitas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.fantasma.receitas.R
import com.fantasma.receitas.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private lateinit var mBinding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSplashScreenBinding.inflate(layoutInflater)

        mBinding.button.setOnClickListener {
            it.findNavController().navigate(R.id.action_splashScreenFragment_to_receitasFragment)
        }

        return mBinding.root
    }
}
