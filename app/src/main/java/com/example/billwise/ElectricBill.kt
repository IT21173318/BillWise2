package com.example.billwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.billwise.databinding.ActivityElectricBillBinding
import java.nio.file.Files.delete


class ElectricBill : AppCompatActivity() {


    private lateinit var binding:ActivityElectricBillBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()

        binding.electricDisplay.setOnClickListener{
            calculateElectricBill()
        }
        binding.elecDelete.setOnClickListener {
            delete()
        }
    }
    private fun initialiseBinding(){
        binding = ActivityElectricBillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun calculateElectricBill( ){

        val enddate = binding.Enddate.text.toString()
        val startdate = binding.StartDate.text.toString()
        val unitPrice =binding.unitP.text.toString()
        val units = binding.usedUnits.text.toString()

        val end = enddate.toInt()
        val start = startdate.toInt()
        val unit = unitPrice.toFloat()
        val useduni = units.toFloat()

        val result = (((end-start)*unit)*useduni)


        val displayString = result.toString()
        binding.resultText.text =displayString

    }

    private fun delete(){
        binding.resultText.text =null
        binding.Enddate.text?.clear()
        binding.StartDate.text?.clear()
        binding.unitP.text?.clear()
        binding.usedUnits.text?.clear()
    }

}