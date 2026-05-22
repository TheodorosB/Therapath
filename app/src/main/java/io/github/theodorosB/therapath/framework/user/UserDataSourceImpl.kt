package io.github.theodorosB.therapath.framework.user

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.github.theodorosB.therapath.data.user.UserDataSource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
): UserDataSource {

    override suspend fun registerUser(
        email: String,
        password: String,
        username: String
    ): Boolean {

        return try {

            val authResult = auth
                .createUserWithEmailAndPassword(email, password)
                .await()

            val uid = authResult.user?.uid ?: return false

            val userData = mapOf(
                "uid" to uid,
                "username" to username,
                "email" to email
            )

            firestore
                .collection("users")
                .document(uid)
                .set(userData)
                .await()

            true

        } catch (e: Exception) {
            false
        }
    }
}