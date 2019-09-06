package com.allerates.appforyou.model


data class UserPojo(
        var ExUserID: String,
        var ExMail: String,
        var ExPassword: String,
        var ExName: String,
        var auth_key: String,
        var ExImage: String,
        var ExBlobImage: String,
        var ExForKey: String?,
        var SurName: String,
        var UserPhone: String,
        var MainCurrency: String,
        var TimeLifeToken: String,
        var ActivateUser: String,
        var ResetPass: String
)