package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        val numberArray = (5..100 step 5).toList()

        /* TODO Step 3: Create adapter to display items from array in Spinner */
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, numberArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.adapter = adapter;


        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Get the selected item from the spinner
                val selectedNumber = parent?.getItemAtPosition(position) as Int

                // Set the text size of the TextView to the selected number
                displayTextView.textSize = selectedNumber.toFloat()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where no item is selected, if necessary
            }
        }


    }
}