package com.example.billwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billwise.databinding.ActivityElectricBillBinding
import com.example.billwise.databinding.ActivityHomeUsageBinding
import com.example.billwise.databinding.ActivityWaterBillBinding
import java.nio.file.Files.delete

class WaterBill : AppCompatActivity() {
    private lateinit var binding: ActivityWaterBillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()

        binding.waterDisplay.setOnClickListener{
            clcwater()
        }
        binding.waterDelete.setOnClickListener{
            delete()
        }

    }

    private fun delete() {
        binding.resultText.text =null
        binding.Enddate.text?.clear()
        binding.StartDate.text?.clear()
        binding.unitP.text?.clear()
        binding.usedUnits.text?.clear()

    }

    private fun clcwater() {

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

    private fun initialiseBinding() {

        binding = ActivityWaterBillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}