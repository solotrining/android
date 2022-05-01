package com.example.train.viewmodel

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.train.module.Auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Sign_InModel : ViewModel() {

    private val Auth: Auth = Auth()

    var auth = Auth.mAuth


    fun createAccount(email: String, password: String,activity:Activity) {
        auth = Firebase.auth
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            activity.applicationContext, "계정 생성 완료.",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(
                            activity.applicationContext, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    }


}