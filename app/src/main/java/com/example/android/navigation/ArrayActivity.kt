package com.example.android.navigation

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Fragment] subclass.
 */
class ArrayActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {

        setContentView(R.layout.fragment_array_activity)

        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(this, R.array.pick_carrier, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        print("onCreate")
        return super.onCreateView(name, context, attrs)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = this
    }


}
