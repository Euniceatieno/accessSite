package com.example.accessite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etEmail:EditText
    lateinit var etPhonenumber:EditText
    lateinit var etPassword:EditText
    lateinit var btnsignup:Button
    lateinit var btntosignin:Button
    lateinit var spgender:Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        onClickListener()
    }
    fun castViews() {
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhonenumber = findViewById(R.id.etPhonenumber)
        etPassword = findViewById(R.id.etPassword)
        btnsignup = findViewById(R.id.btnsignup)
        btntosignin = findViewById(R.id.btntosignin)
        spgender = findViewById(R.id.spgender)
        var thegenders = arrayOf("Male", "Female", "NoNBinary")
        var genderAdapter =
            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, thegenders)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spgender.adapter = genderAdapter


    }
    fun onClickListener(){
        btnsignup.setOnClickListener {
        var spgender=spgender.selectedItem.toString()
        if(etName.text.toString().isEmpty() || etEmail.text.toString().isEmpty() || etPhonenumber.text.toString().isEmpty()||
        etPassword.text.toString().isEmpty()){
            etName.setError("Enter name")
            etEmail.setError("Enter Email")
            etPhonenumber.setError("Enter Phone number")
            etPassword.setError("Enter Password")
        }
        else{
            var details=UserDetails(name=etName.text.toString(),
                email=etEmail.text.toString(),
                phonenumber=etPhonenumber.text.toString(),
                password=etPassword.text.toString())
            Toast.makeText(baseContext,details.toString(),Toast.LENGTH_LONG).show()
        }

      }
    btntosignin.setOnClickListener {
        var intent=Intent(baseContext,signup::class.java)
        startActivity(intent)
    }
    }
}

data class UserDetails(var name:String,var email:String,var phonenumber:String,var password:String)
