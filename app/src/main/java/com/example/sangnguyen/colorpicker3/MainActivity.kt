package com.example.sangnguyen.colorpicker3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.graphics.ColorUtils.blendARGB
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.PackageManager
import com.example.sangnguyen.colorpicker3.R.id.Widget1


class MainActivity : AppCompatActivity() {

    var progressPercent: Float = 0f
    var firstColor = 0
    var secondColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        blenderBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressPercent = progress / 100f
                setBlendColor(progressPercent)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    fun openColorPickerApp(view : View, requestCode: Int){
        val launchColorPicker = packageManager.getLaunchIntentForPackage("com.example.sangnguyen.colorpicker")  as Intent
        startActivityForResult(launchColorPicker, requestCode)
    }

    fun setBlendColor(blendPercent: Float) {
        var color = blendARGB(firstColor, secondColor, blendPercent)
        blenderView.setBackgroundColor(color)
    }

    fun pickColor(view: View) {
        openColorPickerApp(view, 1)
    }
    fun pickSecondColor(view: View) {
        openColorPickerApp(view, 2)
    }

    fun textColor (view: View) {
        // create the color picker intent
        val textColor = Intent(this, ColorPicker::class.java)
        startActivityForResult(textColor, 3)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            firstColor = data!!.getIntExtra("Color", 0)
            Widget1.setBackgroundColor(firstColor)
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            secondColor = data!!.getIntExtra("Color", 0)
            Widget2.setBackgroundColor(secondColor)
        }
        if (requestCode == 3 && resultCode == Activity.RESULT_OK) {
            secondColor = data!!.getIntExtra("Color", 0)
            colorChangeText.setBackgroundColor(secondColor)
        }
    }
}