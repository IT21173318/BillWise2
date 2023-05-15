package com.example.billwise


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Home : Fragment() {

    //Declere variables for Buttons
    private lateinit var btnHomeUsage: Button
    private lateinit var btncategories: Button
    private lateinit var btnelectriccal: Button
    private lateinit var btnwatercal: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //call the home usage
        btnHomeUsage = view.findViewById(R.id.homeusege)

        btnHomeUsage.setOnClickListener {
            val intent = Intent(requireContext(), HomeUsage::class.java)
            startActivity(intent)
        }

        // call the categories   chage the next activity uresha
        btncategories = view.findViewById(R.id.categories)

        btncategories.setOnClickListener {
            val intent = Intent(requireContext(), Categories::class.java)
            startActivity(intent)
        }

        btnelectriccal = view.findViewById(R.id.ElectricBill)

        btnelectriccal.setOnClickListener {
            val intent = Intent(requireContext(), ElectricBill::class.java)
            startActivity(intent)
        }

        btnwatercal = view.findViewById(R.id.waterbill)

        btnwatercal.setOnClickListener {
            val intent = Intent(requireContext(),WaterBill::class.java)
            startActivity(intent)
        }



        

        return view
    }
}
