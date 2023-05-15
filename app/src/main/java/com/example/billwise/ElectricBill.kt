package com.example.billwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billwise.databinding.ActivityElectricBillBinding
import java.nio.file.Files.delete

class ElectricBill : AppCompatActivity() {

    private lateinit var binding:ActivityElectricBillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initiliseBinding()

        binding.electricDisplay.setOnClickListener {
            calculateElectricBill()
        }
        binding.elecDelete.setOnClickListener {
            delete()
        }

    }


    private fun initiliseBinding() {
        binding = ActivityElectricBillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun calculateElectricBill() {

        val end = binding.Enddate.text.toString()
        val start = binding.StartDate.text.toString()
        val units = binding.unitP.text.toString()
        val unit = binding.usedUnits.text.toString()


        val e1 = end.toInt()
        val s1 = start.toInt()
        val un = units.toFloat()
        val u = unit.toFloat()


        val result = (((e1-s1)*un)*u)

        val displayString = result.toString()
        binding.resultText.text =displayString

    }
    private fun delete() {

        binding.resultText.text =null
        binding.Enddate.text?.clear()
        binding.StartDate.text?.clear()
        binding.unitP.text?.clear()
        binding.usedUnits.text?.clear()


    }

}