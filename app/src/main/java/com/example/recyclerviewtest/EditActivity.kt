package com.example.recyclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.recyclerviewtest.databinding.ActivityEditBinding
import com.google.android.material.textfield.TextInputEditText

class EditActivity : AppCompatActivity() {
    private lateinit var bindingEditActivity: ActivityEditBinding
    private var indexImage: Int = 0
    private var imageId: Int = R.drawable.pic0
    private val imageIdList = listOf(
        R.drawable.pic0,
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingEditActivity = ActivityEditBinding.inflate(layoutInflater)
        setContentView(bindingEditActivity.root)
    }

    fun buttonNextClick(view: View) {
        indexImage = if(indexImage > imageIdList.size - 2) 0 else ++indexImage
        bindingEditActivity.apply {
            imageId = imageIdList[indexImage]
            imageViewEdit.setImageResource(imageId)
        }
    }

    fun buttonDoneClick(view: View) {
        bindingEditActivity.apply {
            val ST = SomeTools(bindingEditActivity.root.context)
            if(!ST.isFieldsEmpty(arrayListOf(textInputTitle, textInputDesc))) {
                val item = DataItem(imageId, textInputTitle.text.toString(), textInputDesc.text.toString())
                val editIntent = Intent().apply {
                    putExtra(Constance.CODE_EDIT_LAUNCHER, item)
                }
                setResult(RESULT_OK, editIntent)

                finish()
            }
        }
    }
}