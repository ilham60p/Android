package com.example.myapplication

import com.example.myapplication.data.UserInfo
import com.example.myapplication.data.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetroServiceInterface {
@POST("login/")
fun login(@Body params:UserInfo):Call<UserResponse>

}


