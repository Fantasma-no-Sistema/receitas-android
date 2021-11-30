package com.fantasma.receitas.view.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fantasma.receitas.R
import com.fantasma.receitas.databinding.FragmentReceitasBinding
import com.fantasma.receitas.domain.Receita
import com.fantasma.receitas.presentation.listarReceitas.ListaReceitasViewModel
import com.fantasma.receitas.utils.Result
import com.fantasma.receitas.view.adapter.ReceitasAdapter

class ReceitasFragment : Fragment() {

    private lateinit var mBinding: FragmentReceitasBinding
    private val mViewModel: ListaReceitasViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentReceitasBinding.inflate(layoutInflater)
        mObserver()
        return mBinding.root
    }

    private fun loadRecyclerView(list: ArrayList<Receita>) {
        val adapter = ReceitasAdapter(list)
        mBinding.rvReceitas.adapter = adapter
        mBinding.rvReceitas.layoutManager = LinearLayoutManager(context)
    }

    private fun mObserver() {
        mViewModel.listaReceitas().observe(
            this,
            {
                when(it) {
                    is Result.Success -> loadRecyclerView(it.data)
                    is Result.Error -> showError(it.error)
                    is Result.Loading -> showLoading()
                }
            }
        )
    }

    private fun showError(error: String) {
        Toast.makeText(context, "Deu erro: $error", Toast.LENGTH_LONG).show()
    }

    private fun showLoading() {
        Toast.makeText(context, "Carregando Lista", Toast.LENGTH_LONG).show()
    }
}