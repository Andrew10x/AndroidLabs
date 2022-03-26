package com.andrew10x.lab1kotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.andrew10x.lab1kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(ChooseTrainFragment.newInstance(),
            R.id.chooseTrainPlaceholder)
        openFrag(ResOutputFragment.newInstance(),
           R.id.resOutputPlaceholder)
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder,
            f).commit()
    }
}