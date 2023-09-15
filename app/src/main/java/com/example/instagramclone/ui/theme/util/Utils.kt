package com.example.instagramclone.ui.theme.util

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.util.UUID

fun uploadImage(uri: Uri, folderName:String): String {
    var imageUrl:String?=null
    FirebaseStorage.getInstance().getReference(folderName).child(UUID.randomUUID().toString()).putFile(uri)
        .addOnSuccessListener {
            it.storage.downloadUrl.addOnSuccessListener {
                imageUrl=it.toString()

            }

            
        }
     return imageUrl!!

}



