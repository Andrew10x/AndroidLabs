package com.andrew10x.lab1kotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R
import android.annotation.SuppressLint

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import androidx.fragment.app.Fragment
import com.andrew10x.lab1kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //private val timeArr = arrayOf("оберіть дату", "9:00", "12:30", "16:50", "19:00", "22:10")
    //private val from: TextView? = null
    //private var to:TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(ChooseTrainFragment.newInstance(),
            com.andrew10x.lab1kotlin2.R.id.chooseTrainPlaceholder)
        openFrag(ResOutputFragment.newInstance(),
            com.andrew10x.lab1kotlin2.R.id.resOutputPlaceholder)
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder,
            f).commit()
    }
}

/*
val timeAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, timeArr)
timeAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

binding.timeSpinner.adapter = timeAdapter
//binding.timeSpinner.prompt = "Час відправлення"

/*binding.choseBtn.setOnClickListener {
    if (timeSpinner!!.selectedItem === "оберіть дату") {
        Toast.makeText(this@MainActivity, com.andrew10x.lab1kotlin.R.string.no_time_input, Toast.LENGTH_LONG).show()
        binding.resOutput.text = ""
    }
    else {
        binding.resOutput.text = ""/*""Ви обрали потяг з міста " + binding.from.text + " до міста " +
                    binding.to.text + "з часом відправки" + timeSpinner!!.selectedItem*/
    }
}*/
}

@SuppressLint("SetTextI18n")
fun onClickChoseBtn(view: View) {
if (binding.timeSpinner.selectedItem === "оберіть дату") {
    Toast.makeText(this@MainActivity, com.andrew10x.lab1kotlin.R.string.no_time_input,
        Toast.LENGTH_LONG).show()
    binding.resOutput.text = ""
}
else {
    binding.resOutput.text = "Ви обрали потяг з міста " + binding.from.text + " до міста " +
                    binding.to.text + " з часом відправки " + binding.timeSpinner.selectedItem
}
}
}*/