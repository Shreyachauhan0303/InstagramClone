package com.example.instagramclone.Model

class User {
    var img: String? = null
    var name: String? = null
    var email: String? = null
    var password: String? = null


    constructor( email: String?, password: String?) {

        this.email = email
        this.password = password
    }

    constructor(img: String?, name: String?, email: String?, password: String?) {
        this.img = img
        this.name = name
        this.email = email
        this.password = password
    }

    constructor()


}