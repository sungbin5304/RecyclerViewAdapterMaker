package com.sungbin.recyclerviewadaptermaker

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sungbin.recyclerviewadaptermaker.library.AdapterHelper
import com.sungbin.recyclerviewadaptermaker.library.options.Option
import com.sungbin.recyclerviewadaptermaker.library.options.Padding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AdapterHelper
            .with(rv)
            .bindLayout(R.layout.test_layout)
            .addViewBindListener { item, view, position ->
                val tv = view as TextView
                tv.text = item[position].toString()
                tv.setOnClickListener { toast("${tv.text} Clicked.") }
            }
            .addOption(Option(null, Padding(16, 16, 16, 16)))
            .create(arrayListOf("안", "녕", "하", "세", "요"))
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun toast(string: String){
        Toast.makeText(
            applicationContext,
            string,
            Toast.LENGTH_SHORT
        ).show()
    }
}
