package io.github.theodorosB.therapath.framework.user.datastore.model

data class UserDatastoreItem(
    val uuid: String = "",
    val isLoginSaved: Boolean = false,
    val localeLanguage: String = ""
)
