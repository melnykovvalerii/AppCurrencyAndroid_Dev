package com.allerates.appforyou.model

data class RegEmail(var auth_key: String)

data class ConfirmMailResult(
        var status: String,
        var message: String
)

data class ActivateUser(
        var status: String,
        var ActivateUser: Boolean
)

data class UserInfoResult (
    var query_content: Array<UserInfo>,
    var img_content: String
)

class UserInfo(
    var exName: String,
    var exImage: String,
    var exUserID: String,
    var userPhone: String,
    var exMail: String,
    var mainCurrency: String,
    var auth_key: String,
    var activateUser: String,
    var surName: String
)

data class SendRecoveryMailResult(
        var status: String,
        var message: String
)

data class BasicResult(
        var status: String,
        var message: String
)