package com.example.sangnguyen.colorpicker3

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.color_picker.*
import kotlinx.android.synthetic.main.second_color_picker.*

/**
 * Created by sangnguyen on 3/10/18.
 */


class SecondColorPicker : AppCompatActivity() {
    var red = 0
    var green = 0
    var blue = 0
    var surfaceColor2 :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_color_picker)

        //Find the seekbar and the textvalue
        val barRed = findViewById<SeekBar>(R.id.redBar)
        barRed.max = 255

        val barGreen = findViewById<SeekBar>(R.id.greenBar)
        barGreen.max = 255

        val barBlue = findViewById<SeekBar>(R.id.blueBar)
        barBlue.max = 255

        //colors


        // Get redBar value from redText and pass color to surfaceview
        redBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //get the value when seekbar is moved
                redText2.text = progress.toString()
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
        greenBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //get the value when seekbar is moved
                greenText2.text = progress.toString()
                green = progress
                setSurfaceViewColor(red, green, blue)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // Get redBar value from blueText and pass color to surfaceview
        blueBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //get the value when seekbar is moved
                blueText2.text = progress.toString()
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
        surfaceColor2 = Color.rgb(redColor, greenColor, blueColor)
        secondWidgetView.setBackgroundColor(surfaceColor2)
    }

    fun sendSecondColor(view: View){
        var myIntent = Intent()
        myIntent.putExtra("Color", surfaceColor2)
        setResult(Activity.RESULT_OK, myIntent)
        finish()
    }

}