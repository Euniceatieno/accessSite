package com.example.accessite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.net.PasswordAuthentication

class signup : AppCompatActivity() {
    lateinit var etliemail:EditText
    lateinit var etlipassword:EditText
    lateinit var btnsignin: Button
    lateinit var btntosignup:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        castViews()
        onClickListener()
    }
    fun castViews(){
        etliemail=findViewById(R.id.etliemail)
        etlipassword=findViewById(R.id.etlipassword)
        btnsignin=findViewById(R.id.btnsignin)
        btntosignup=findViewById(R.id.btntosignup)
    }
    fun onClickListener(){
        btnsignin.setOnClickListener {
            if (etliemail.text.toString().isEmpty() || etlipassword.text.toString().isEmpty()) {
                etliemail.setError("Enter Email")
                etlipassword.setError("Enter Password")
            } else {
                var logindetails = LoginDetails(
                    email = etliemail.text.toString(),
                    password = etlipassword.text.toString())
                Toast.makeText(baseContext, logindetails.toString(), Toast.LENGTH_LONG).show()
            }
            }
          btntosignup.setOnClickListener {
                var intent1= Intent(baseContext,MainActivity::class.java)
                startActivity(intent1)

        }
    }
}
data class LoginDetails(var email:String,var password:String)