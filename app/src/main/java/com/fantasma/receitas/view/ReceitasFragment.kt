package com.fantasma.receitas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fantasma.receitas.R
import com.fantasma.receitas.databinding.FragmentReceitasBinding

class ReceitasFragment : Fragment() {

    private lateinit var mBinding: FragmentReceitasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentReceitasBinding.inflate(layoutInflater)
        mBinding.button.setOnClickListener {
            findNavController().navigate(R.id.action_receitasFragment_to_splashScreenFragment)
        }
        return mBinding.root
    }
}