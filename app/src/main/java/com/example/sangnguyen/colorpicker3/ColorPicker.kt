package com.example.sangnguyen.colorpicker3

/**
 * Created by sangnguyen on 3/7/18.
 */

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.*
import com.example.sangnguyen.colorpicker3.R.id.*
import kotlinx.android.synthetic.main.color_picker.*


class ColorPicker : AppCompatActivity() {
    var red = 0
    var green = 0
    var blue = 0
    var surfaceColor :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color_picker)

       //Find the seekbar and the textvalue
        val barRed = findViewById<SeekBar>(R.id.redBar)
        barRed.max = 255

        val barGreen = findViewById<SeekBar>(R.id.greenBar)
        barGreen.max = 255

        val barBlue = findViewById<SeekBar>(R.id.blueBar)
       barBlue.max = 255

        //colors


        // Get redBar value from redText and pass color to surfaceview
        redBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //get the value when seekbar is moved
                redText.text = progress.toString()
                red = progress
                setSurfaceViewColor(red, green, blue)

                /*
                surfaceView.setBackgroundColor(progress)
                if (progress < 50) {
                    surfaceView.setBackgroundResource(R.color.redSeekBar)
                } else if (progress in 51..99) {
                    surfaceView.setBackgroundResource(R.color.blueSeekBar)
                } else{
                    surfaceView.setBackgroundResource(R.color.greenSeekBar)

                }
                */
            }


            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // Get redBar value from greenText and pass color to surfaceview
        greenBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //get the value when seekbar is moved
                greenText.text = progress.toString()
                green = progress
                setSurfaceViewColor(red, green, blue)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // Get redBar value from blueText and pass color to surfaceview
        blueBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //get the value when seekbar is moved
                blueText.text = progress.toString()
                blue = progress
                setSurfaceViewColor(red, green, blue)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun setSurfaceViewColor(redColor: Int, greenColor: Int, blueColor: Int) {
        surfaceColor = Color.rgb(redColor, greenColor, blueColor)
        firstWidgetView.setBackgroundColor(surfaceColor)
    }

    fun sendColor(view: View){
        var myIntent = Intent()
        myIntent.putExtra("Color", surfaceColor)
        setResult(Activity.RESULT_OK, myIntent)
        finish()
    }
}