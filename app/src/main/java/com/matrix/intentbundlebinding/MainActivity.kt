package com.matrix.intentbundlebinding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.matrix.intentbundlebinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
       private var binding:ActivityMainBinding?=null
    var currentvalue:Int?=0
    var currentoperation:String?=null



    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding?.btnNumber?.setOnClickListener {
            currentvalue=currentvalue?.plus(2)
            totalresult()
            Toast.makeText(this, "Current Value: $currentvalue", Toast.LENGTH_SHORT).show()
        }
        binding?.btnAdd?.setOnClickListener {
            performoperation("+")
            totalresult()
            Toast.makeText(this,"Current Operation:$currentoperation \nCurrent Solution: $currentvalue",Toast.LENGTH_SHORT).show()
        }
        binding?.btnMul?.setOnClickListener {
            performoperation("*")
            totalresult()
            Toast.makeText(this,"Current Operation:$currentoperation \nCurrent Solution: $currentvalue",Toast.LENGTH_SHORT).show()
        }
        binding?.btnDiv?.setOnClickListener {
            performoperation("/")
            totalresult()
            Toast.makeText(this,"Current Operation:$currentoperation \nCurrent Solution: $currentvalue",Toast.LENGTH_SHORT).show()
        }
        binding?.btnMinus?.setOnClickListener {
            performoperation("-")
            totalresult()
            Toast.makeText(this,"Current Operation:$currentoperation \nCurrent Solution: $currentvalue",Toast.LENGTH_SHORT).show()
        }



    }
    private fun performoperation(operation:String){
        currentoperation=operation

        when(currentoperation){
            "+" -> currentvalue = currentvalue?.plus(2)
            "-" -> currentvalue = currentvalue?.minus(2)
            "*" -> currentvalue = currentvalue?.times(2)
            "/" ->{if(currentvalue!=0){
                currentvalue = currentvalue?.div(2)
            }
            else{
                Toast.makeText(this,"This can't be divided /n First Enter some Value",Toast.LENGTH_LONG).show()

            }
            }
        }
    }
    private fun totalresult(){
        binding?.txtTotal?.text= currentvalue.toString()
    }
}