package com.example.billwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.billwise.databinding.ActivityAddItemBinding
import com.example.billwise.models.Item
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddItem : AppCompatActivity() {

    //declare variable and connection with database
        private lateinit var binding :ActivityAddItemBinding
        private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //submit the items details
        binding.AddSubmit.setOnClickListener{
            var name = binding.iName.text.toString()
            var wattage = binding.iWattage.text.toString()
            var quantity = binding.iQuantity.text.toString()

            //connection with database Items
            database = FirebaseDatabase.getInstance().getReference("Items")
            var id = database.push().key

            //Assign variables
            val item = Item(name,wattage,quantity,id)
            database.child(id!!).setValue(item).addOnCompleteListener{

                //clear data
                binding.iName.text.clear()
                binding.iWattage.text.clear()
                binding.iQuantity.text.clear()

                //get in successful message
                Toast.makeText(this,"Successfully Added", Toast.LENGTH_SHORT).show()
                //Redirect into Categories
                val intent = Intent(this, Categories::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener{
                //get in Error message

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

            }
        }



    }
}
