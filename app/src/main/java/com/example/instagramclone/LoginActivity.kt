package com.example.instagramclone

import android.content.Intent
import android.os.Build.USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.instagramclone.databinding.ActivityLoginBinding
import com.example.instagramclone.databinding.ActivitySignUpBinding
import com.example.instagramclone.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
            if (binding.eMail.editText?.text.toString().equals("") or
                binding.pass.editText?.text.toString().equals("")
            ) {
                Toast.makeText(this@LoginActivity, "Fill all the details", Toast.LENGTH_SHORT)
                    .show()

            } else {
                var user = User(binding.eMail.editText?.text.toString(),
                        binding.pass.editText?.text.toString())
                Firebase.auth.signInWithEmailAndPassword(user.email!!,user.password!!)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
                            finish()

                        } else {
                            Toast.makeText(this@LoginActivity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()

                        }
                    }


            }

        }

    }
}