package com.example.recyclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding
    private val adapter = RecAdapterMain()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        init()

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                adapter.addItem(it.data?.getSerializableExtra(Constance.CODE_EDIT_LAUNCHER) as DataItem) //Попоробовать вместо Serializable -> Paracable
            }
        }

        Log.d("MyTag", "pizdec2")
    }

    private fun init() {
        bindingMainActivity.apply {
            recyclerViewMain.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerViewMain.adapter = adapter
        }
    }

    private fun buttonAddItemClick(view: View) { //вылетает даже не попав в действие
        Log.d("MyTag", "pizdec")
        editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        Log.d("MyTag", "pizdec1")
    }
}