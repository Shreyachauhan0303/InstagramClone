package com.example.instagramclone.ui.theme.Model

class User {
    var img: String? = null
    var name: String? = null
    var email: String? = null
    var password: String? = null

    constructor()
    constructor(img: String?, name: String?, email: String?, password: String?) {
        this.img = img
        this.name = name
        this.email = email
        this.password = password
    }
}