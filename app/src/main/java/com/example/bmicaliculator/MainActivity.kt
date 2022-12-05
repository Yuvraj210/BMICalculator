package com.example.bmicaliculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        calculate.setOnClickListener {

            if(kg.text.isNotEmpty() && ft.text.isNotEmpty() && Inch.text.isNotEmpty()){
//
                val kilog=kg.text.toString().toDouble()
                val feet=ft.text.toString().toDouble()
                val INCH=Inch.text.toString().toDouble()

                val Totalinch=feet*12+INCH
                val cm=Totalinch*2.53
                val Meter=cm/100

              if (kilog>0 && kilog<500 && feet<12 && feet>1 && INCH<12&& INCH>0){

                          val intent=Intent(this,Result_Activity::class.java)
                          intent.putExtra("yuvi",calculatebmi(kilog,Meter))
                          startActivity(intent)
                  kg.text.clear()
                  ft.text.clear()
                  Inch.text.clear()

              }else{

                  Toast.makeText(this, "incorrect value", Toast.LENGTH_SHORT).show()
              }

            }
            else{
                Toast.makeText(this, "A field is missing", Toast.LENGTH_SHORT).show()
            }

        }



    }

   private fun calculatebmi(weight:Double,height:Double)=BigDecimal(weight/(height*height))
        .setScale(2,RoundingMode.HALF_EVEN).toDouble()


}