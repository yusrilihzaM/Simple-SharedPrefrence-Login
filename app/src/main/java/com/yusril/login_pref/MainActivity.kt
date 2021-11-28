package com.yusril.login_pref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yusril.login_pref.databinding.ActivityMainBinding
import com.yusril.login_pref.helper.Constant
import com.yusril.login_pref.helper.PrefrencesHelper

class MainActivity : AppCompatActivity() {
    lateinit var prefrencesHelper: PrefrencesHelper
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefrencesHelper= PrefrencesHelper(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            if (binding.editUsername.text.isNotEmpty() && binding.editPassword.text.isNotEmpty()){
                val username=binding.editUsername.text.toString()
                val password=binding.editPassword.text.toString()
                saveSession(username,password)
                showMessage("Login Berhasil")
                moveIntent()
            }
        }
    }

    private fun showMessage(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        if (prefrencesHelper.getBoolean(Constant.PREFS_IS_LOGIN)){
            moveIntent()
        }
    }

    private  fun moveIntent(){
        startActivity(Intent(this,UserActivity::class.java))
        finish()
    }
    private  fun saveSession(username:String, password:String){
        prefrencesHelper.put(Constant.PREFS_IS_USERNAME,username)
        prefrencesHelper.put(Constant.PREFS_IS_PASSWORD,password)
        prefrencesHelper.put(Constant.PREFS_IS_LOGIN,true)
    }
}