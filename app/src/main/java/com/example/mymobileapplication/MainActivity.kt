package com.example.mymobileapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView: TextView = findViewById(R.id.greetingTextView)
        val inputEditText: EditText = findViewById(R.id.inputEditText)
        val optionsSpinner: Spinner = findViewById(R.id.optionsSpinner)
        val actionButton: Button = findViewById(R.id.actionButton)
        val featureSwitch: Switch = findViewById(R.id.featureSwitch)

        // Set up the Spinner with a list of items
        val spinnerItems = arrayOf("Option 1", "Option 2", "Option 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        optionsSpinner.adapter = adapter

        // Set OnClickListener for the Button
        actionButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            Toast.makeText(this, "Button Clicked! You entered: $inputText", Toast.LENGTH_SHORT).show()
        }

        // Set OnItemSelectedListener for the Spinner
        optionsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Set OnCheckedChangeListener for the Switch
        featureSwitch.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "enabled" else "disabled"
            Toast.makeText(this, "Feature is $status", Toast.LENGTH_SHORT).show()
        }
    }
}
