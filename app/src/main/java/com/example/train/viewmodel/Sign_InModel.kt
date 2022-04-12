package com.example.train.viewmodel

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.train.module.Auth

class Sign_InModel : ViewModel() {

    private val auth: Auth = Auth()

    var success:Boolean = false

    fun createAccount(email: String, password: String,activity:Activity) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.mAuth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        success = true
                        Toast.makeText(
                            activity.applicationContext, "계정 생성 완료.",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        success = false
                        Toast.makeText(
                            activity.applicationContext, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}