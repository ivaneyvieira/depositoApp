package br.com.pintos.depositoapp.model

data class User(
        var id: Long? = null,
        var userName: String?,
        var chapa: String?,
        var userSaci: String?,
        var firstName: String?,
        var lastName: String?,
        var title: String?,
        var passw: String?
)
