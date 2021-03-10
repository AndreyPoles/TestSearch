package com.search.searchimages.activitys

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.search.searchimages.ImageAdapter
import com.search.searchimages.MainViewModel
import com.search.searchimages.MainViewModelFactory
import com.search.searchimages.R
import com.search.searchimages.repository.Repository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var tags = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSearch.setOnClickListener {
            init()
        }
    }

    fun init() {

        lateinit var viewModel: MainViewModel

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost(editTextSearch.text.toString())
        viewModel.myResponse.observe(this, Observer { response ->

            for (i in 0 until response.data.size - 1) {
                tags.add(response.data[i].images.original.url)

                lifecycleScope.launch {
                    val getbitmap = getBitmap(i)

                    Log.d("tag", getbitmap.toString())
                }

            }

            createList()

        })
    }

    fun createList() {
        val linearLayoutManager = GridLayoutManager(this,2 )
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        listImages.layoutManager = linearLayoutManager

        listImages.layoutManager = linearLayoutManager

        val adapter = ImageAdapter(tags, this)
        listImages.adapter = adapter
    }

    private suspend fun getBitmap(count: Int): Bitmap {
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data(tags[count])
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }

}