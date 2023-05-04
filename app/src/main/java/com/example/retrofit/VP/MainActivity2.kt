package com.example.retrofit.VP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.RV.photo_RV_Adapter
import com.example.retrofit.Retrofit_Interface
import com.example.retrofit.VO.PhotoVO
import com.example.retrofit.databinding.ActivityMain2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding

    var photo_list:MutableList<PhotoVO> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        뷰페이저 어뎁터
        val adapter = photo_VP_Adapter(this, photo_list)
        binding.vp1.adapter = adapter

        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//        인터페이스 타입의 서비스 객체 얻기
        var networkService: Retrofit_Interface = retrofit.create(Retrofit_Interface::class.java)
//        네트워크 통신시도
        val userListCall = networkService.getPhoto(1,30,"latest")

//        네트워크 통신 시도
        userListCall.enqueue(object : Callback<MutableList<PhotoVO>> {
            override fun onResponse(call: Call<MutableList<PhotoVO>>, response: Response<MutableList<PhotoVO>>) {
                if(response.isSuccessful){
                    photo_list.clear()
                    response.body()?.let { photo_list.addAll(it) }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MutableList<PhotoVO>>, t: Throwable) {
                call.cancel()
                Log.d("retrofit", "실패")
            }
        })
    }
}