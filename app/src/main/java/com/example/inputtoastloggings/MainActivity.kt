package com.example.inputtoastloggings

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageSwitcher
import android.widget.SeekBar
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    private lateinit var firstButton: Button
    private lateinit var secondButton: Button
    private lateinit var thirdButton: Button
    private lateinit var mainTextEdit: EditText

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var mainSwitch: Switch
    private lateinit var mainSeek: Seekbar

    private var switchPosition: Boolean = false

    private val LOG_TAG_BUTTON = "Button"
    private val LOG_TAG_TEXT = "Text"
    private val LOG_TAG_SWITCH = "Switch"
    private val LOG_TAG_SEEK = "Seek"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        this.connectViews()
        this.setupButtonCallbacks()
        this.setupTextCallbacks()
        this.setupSwitchCallbacks()
        this.setupSeekBarCallbacks()

        this.switchPosition = this.mainSwitch.isChecked
    }

    fun connectViews() {
        this.firstButton = this.findViewById(R.id.first_button)
        this.secondButton = this.findViewById(R.id.second_button)
        this.thirdButton = this.findViewById(R.id.third_button)

        //
        this.mainTextEdit = this.findViewById(R.id.main_text_edit)

        //
        this.mainSwitch = this.findViewById(R.id.main_switch)

        //
        this.mainSeek = this.findViewById(R.id.main_seek)
    }

    private fun setupButtonCallbacks() {

        this.firstButton.setOnClickListener { v: View ->
            val btn: Button = (v as Button)
            btn.text = this.getString(R.string.clicked_message)

            if ( this.switchPosition ) {
                Log.i(LOG_TAG_BUTTON, msg: "Make button 1 Toast !")
//                println("Make button 1 Toast !")
                Toast.makeText(context: this, R.string.toast_text_1, Toast.LENGTH_SHORT).show()
            }

                Log.i(LOG_TAG_TEXT, msg: "First button was clicked")
            println("First button was clicked")

        }

        // Reusable Listeners
        val buttonClickListener = View.OnClickListener { v: View ->
            val btn: Button = (v as Button)
            btn.text = this.getString(R.string.clicked_message)
            println("A button was clicked")
        }

        val buttonLongPressListener = View.OnLongClickListener { v: View ->
            val btn: Button = (v as Button)
            btn.text = this.getString(R.string.long_pressed_message)

//            if ( this.switchPosition ) {
//                println("Make button 1 Toast !")
//                Toast.makeText(context: this, this.getString(R.string.long_toast_message), Toast.LENGTH_LONG).show()
//            }

            if ( this.switchPosition ) {
//                Log.i(LOG_TAG_BUTTON, msg: "Make button 1 Toast !")
                println("Make button 1 Toast !")
                Toast.makeText(context: this, R.string.toast_text_long, Toast.LENGTH_LONG).show()
            }

            println("A button was long pressed")
            true
        }

        this.secondButton.setOnClickListener(buttonClickListener)
        this.secondButton.setOnLongClickListener(buttonLongPressListener)
        this.thirdButton.setOnClickListener(buttonClickListener)
        this.thirdButton.setOnLongClickListener(buttonLongPressListener)
    }


    private fun setupTextCallbacks() {
        this.mainTextEdit.setOnKeyListener { v: View, k: Int, event: KeyEvent -> Boolean

            println("Text key press was detected!: $k :: $event")
            false
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun setupSwitchCallbacks() {

        this.mainSwitch.setOnClickListener { v: View ->
            val sw: Switch = ( v as Switch )
            this.switchPosition = sw.isChecked
            println("Switch was clicked to: ${sw.isChecked}")
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun setupSeekBarCallbacks() {

        this.mainSwitch.setOnSeekBarChangeListener( object: SeekBar.OnSeekBarChangeListener {

            // TODO: Fix some stuff
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean)
            {
                println("SeekBar has been changed to: ${sb?.progress}")
            }

            // TODO: Implement this other thing
            override fun onStartTrackingTouch(p0: seekBar?) {}

            // TODO: Implement this other thing
            override fun onStopTrackingTouch(p0: seekBar?) {}

        })
    }
//
//    private fun rememberSwitchPosition() {
//        this.switchPosition =
//    }
}