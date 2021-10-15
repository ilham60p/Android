package com.example.myapplication.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.RetroInstance
import com.example.myapplication.RetroServiceInterface
import com.example.myapplication.data.UserInfo
import com.example.myapplication.data.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var neyse = ""
var myname = ""
@Composable
//@Preview

fun SignInPage(context:Context){
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }



    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(value = username,
            onValueChange ={ username = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Your username here")}
        )

        OutlinedTextField(value = password,
            onValueChange ={ password = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Your password here")}

        )
        
        Button(onClick = {
            senddatatoServer(username,password,context)
            Toast.makeText(context,"basildi",Toast.LENGTH_LONG).show()
                         },
            modifier = Modifier.padding(horizontal = 8.dp)

        ) {
            Text(text = "Sign in")

        }

Text(text = username)


    }

}


fun senddatatoServer(username:String,password:String,context: Context){
    val userInfo = UserInfo("zeynal336","havana3004")

    val retroService  = RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
        val call = retroService.login(userInfo)
        call.enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(context,"ugursuz oldu",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    Toast.makeText(context,"ugurludur",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context,"hecne gelmedi",Toast.LENGTH_LONG).show()

                }
            }
        })



}
