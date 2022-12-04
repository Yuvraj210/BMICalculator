package com.example.bmicaliculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_result.*

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val BMI=intent.getDoubleExtra("yuvi",-1.0)
        if (BMI==-1.0){
            ContainerR.visibility= View.GONE
        }else{

            Bmiresult.text=BMI.toString()
            if (BMI<18.5){

                ContainerR.setBackgroundResource(R.color.yellow)
                mark_icon.setImageResource(R.drawable.correct_mark)
                imageResult.setImageResource(R.drawable.fit)
                Title.text="you are underweight"

            }else if (BMI<25){
                ContainerR.setBackgroundResource(R.color.green)
                mark_icon.setImageResource(R.drawable.correct_mark)
                imageResult.setImageResource(R.drawable.fit)
                Title.text="you are healthy"

            }else{
                ContainerR.setBackgroundResource(R.color.red)
                mark_icon.setImageResource(R.drawable.wrong_mark)
                imageResult.setImageResource(R.drawable.fat)
                Title.text="you are Overweight"

            }
        }

        val scale=AnimationUtils.loadAnimation(this,R.anim.animationscale)

        mark_icon.animation=scale


    }
}