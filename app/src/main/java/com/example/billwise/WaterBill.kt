package com.example.billwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billwise.databinding.ActivityElectricBillBinding
import com.example.billwise.databinding.ActivityWaterBillBinding
import java.nio.file.Files.delete

class WaterBill : AppCompatActivity() {

    private lateinit var binding: ActivityWaterBillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()

        binding.waterDisplay.setOnClickListener{
            calculateWaterBill()
        }
        binding.waterbtnedelete.setOnClickListener {
            delete()
        }

    }
    private fun initialiseBinding(){
        binding = ActivityWaterBillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun calculateWaterBill( ){

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
