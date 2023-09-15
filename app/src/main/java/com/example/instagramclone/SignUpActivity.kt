package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.instagramclone.databinding.ActivitySignUpBinding
import com.example.instagramclone.ui.theme.Model.User
import com.example.instagramclone.ui.theme.util.USER_NODE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    val binding by lazy{
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var user: User
    private val launcher=registerForActivityResult(ActivityResultContracts.GetContent()){
        uri->
        uri?.let {

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        user=User()
        binding.btnSignUp.setOnClickListener{
            if(binding.name.editText?.text.toString().equals("") or
                binding.email.editText?.text.toString().equals("")  or
                        binding.password.editText?.text.toString().equals("")
                                    ){
                                Toast.makeText(this@SignUpActivity,"Please fill all the information", Toast.LENGTH_SHORT).show()
                            } else{
                                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                                    binding.email.editText?.text.toString(),
                                    binding.password.editText?.text.toString()


                                ).addOnCompleteListener {
                                    result->
                                    if(result.isSuccessful){
                                        user.name=binding.name.editText?.text.toString()
                                        user.password=binding.password.editText?.text.toString()
                                        user.email =binding.email.editText?.text.toString()
                                        Firebase.firestore.collection(USER_NODE).document(Firebase.auth.currentUser!!.uid).set(user)
                                            .addOnSuccessListener {
                                                Toast.makeText(this@SignUpActivity,"login",Toast.LENGTH_SHORT).show()
                                            }
                                    } else{
                                        Toast.makeText(
                                            this@SignUpActivity,result.exception?.localizedMessage,Toast.LENGTH_SHORT
                                        ).show()



                                    }
                                }

            }

        }


    }
}

