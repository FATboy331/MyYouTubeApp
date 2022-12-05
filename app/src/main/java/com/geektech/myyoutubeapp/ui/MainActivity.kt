package com.geektech.myyoutubeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.geektech.myyoutubeapp.R
import com.geektech.myyoutubeapp.base.BaseActivity
import com.geektech.myyoutubeapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: MainViewModel

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    override fun initClickListener() {

    }

    override fun setupLiveData() {
viewModel.getPlayList().observe(this){
    Toast.makeText(this, it.kind.toString(),Toast.LENGTH_SHORT).show()
}
    }

    override fun setUI() {
     viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun checkInternet() {

    }


}