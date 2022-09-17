package com.example.inputtoastloggings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageSwitcher
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var firstButton: Button
    private lateinit var secondButton: Button
    private lateinit var thirdButton: Button

    private lateinit var mainTextEdit: EditText
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
                Toast.makeText(context: this, this.getString(R.string.short_toast_message), Toast.LENGTH_SHORT).show()
            }

                Log.i(LOG_TAG_BUTTON, msg: "First button was clicked")
//            println("First button was clicked")

        }

        // Reusable Listeners
        val buttonClickListener = View.OnClickListener { v: View ->
            val btn: Button = (v as Button)
            btn.text = this.getString(R.string.clicked_message)
            println("A button was clicked")
        }

        val buttonLongPressedListener = View.OnLongClickListener { v: View ->
            val btn: Button = (v as Button)
            btn.text = this.getString(R.string.long_pressed_message)

            if ( this.switchPosition ) {
                println("Make button 1 Toast !")
                Toast.makeText(context: this, this.getString(R.string.long_toast_message), Toast.LENGTH_LONG).show()
            }

            println("A button was long pressed")
            true
        }

        this.secondButton.setOnClickListener(butonClickListener)
        this.secondButton.setOnLongClickListener(butonClickListener)
        this.thirdButton.setOnClickListener(butonClickListener)
        this.thirdButton.setOnLongClickListener(butonClickListener)
    }

    private fun setupTextCallbacks() {
        this.mainTextEdit.setOnKeyListener { v: View, k: Int, event: KeyEvent ->
            Boolean
            println("Text key press was detected!: $k :: ")
            false
        }
    }

    //
    private fun setupSeekBarCallbacks() {
        this.mainSwitch.setOnClickListener { v: View ->
            val sw: Switch = ( v as Switch )
            println("Text key press was detected!: ${sw.isChecked}")
        }
    }

    //
    private fun setupSwitchCallbacks() {

        this.mainSwitch.setOnSeekBarChangeListener( object: SeekBar.OnSeekBarChangeListener {

            // TODO: Fix some stuff
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean)
            {
                println("SeekBar has been changed to: ${sb?.progress}")
            }

            // TODO: Implement this other thing
            override fun onStartTrackingTouch(p0: seekBar?) {}

            // TODO: Implement this other thing
            override fun onStartTrackingTouch(p0: seekBar?) {}

        })
    }

    private fun rememberSwitchPosition() {
        this.switchPosition =
    }
}