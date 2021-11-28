package com.yusril.login_pref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yusril.login_pref.databinding.ActivityMainBinding
import com.yusril.login_pref.databinding.ActivityUserBinding
import com.yusril.login_pref.helper.Constant
import com.yusril.login_pref.helper.PrefrencesHelper

class UserActivity : AppCompatActivity() {
    lateinit var prefrencesHelper: PrefrencesHelper
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        prefrencesHelper= PrefrencesHelper(this)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textUsername.text=prefrencesHelper.getString(Constant.PREFS_IS_USERNAME)

        binding.buttonLogout.setOnClickListener {
            prefrencesHelper.clear()
            showMessage("Berhasil Keluar")
            moveIntent()
        }

    }
    private  fun moveIntent(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
    private fun showMessage(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}