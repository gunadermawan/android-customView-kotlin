package com.gunder.customview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myButton = findViewById(R.id.myButton)
        myEditText = findViewById(R.id.myEditText)
        setMyButtonEnabled()

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setMyButtonEnabled()
            }

            override fun afterTextChanged(p0: Editable?) {
                // do nothing
            }

        })
        myButton.setOnClickListener {
            Toast.makeText(this@MainActivity, myEditText.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setMyButtonEnabled() {
        val result = myEditText.text
        myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }
}