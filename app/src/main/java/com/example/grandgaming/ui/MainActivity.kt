package com.example.grandgaming.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.grandgaming.R
import com.example.grandgaming.adapters.CatAdapter
import com.example.grandgaming.data.model.APIItemItem
import com.example.grandgaming.data.repository.CatRepository
import com.example.grandgaming.databinding.ActivityMainBinding
import com.example.grandgaming.viewModelFactory.CatViewModelFactory
import com.example.grandgaming.viewmodels.CatImageViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CatImageViewModel by viewModels {
        CatViewModelFactory(repository = CatRepository())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        handleTheme()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpUi()
        observeData()

    }

    private fun setUpUi() {
        binding.progressCircular.isIndeterminate=true
        binding.recview.apply {
            layoutManager = GridLayoutManager(context, 2)
        }
    }


    private fun observeData() {
        viewModel.getImagesData()
        viewModel.catimges.observe(this@MainActivity) { response ->
            response?.let {
                val adapter = CatAdapter(this@MainActivity,response)
                binding.recview.adapter = adapter
                binding.progressCircular.visibility= View.GONE
                binding.recview.visibility=View.VISIBLE
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.errorState.observe(this@MainActivity) { errorMessage ->
            errorMessage?.let {
                binding.progressCircular.visibility = View.GONE
                binding.recview.visibility = View.GONE
                binding.errorstate.visibility=View.VISIBLE

            }
        }
    }


    private fun handleTheme() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowCompat.getInsetsController(window, window.decorView)?.isAppearanceLightStatusBars =
            true
    }


}