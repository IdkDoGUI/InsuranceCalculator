package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        spinnerAge.onItemClickListener = this

        button.setOnClickListener {
            calculatePremium()
        }

        button2.setOnClickListener {
            reset()
        }
    }

    private fun reset(){
        spinnerAge.setSelection(0)
        RadioGroupGender.clearCheck()
        checkBox.isChecked = false
        textView4.text = getString(R.string.insurance_premium)

    }

    private fun calculatePremium(){
        val position = spinnerAge.selectedItemPosition
        val gender = RadioGroupGender.checkedRadioButtonId
        var premium: Int
        premium = 0
        when (position) {
            0 -> {
                premium = 60
            }
            1 -> {
                premium = 70
                if(gender == R.id.radioButtonMale) premium += 50
                if(checkBox.isChecked) premium += 100
            }
            2 -> {
                premium = 90
                if(gender == R.id.radioButtonMale) premium += 100
                if(checkBox.isChecked) premium += 150
            }
            3 -> {
                premium = 120
                if(gender == R.id.radioButtonMale) premium += 150
                if(checkBox.isChecked) premium += 200
            }
            4 -> {
                premium = 150
                if(gender == R.id.radioButtonMale) premium += 200
                if(checkBox.isChecked) premium += 250
            }
            5 -> {
                premium = 150
                if(gender == R.id.radioButtonMale) premium += 200
                if(checkBox.isChecked) premium += 300
            }
        }

        textView4.text = String.format("%s %d",getString(R.string.insurance_premium),premium)
    }
}
