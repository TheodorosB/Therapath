package io.github.theodorosB.therapath.framework.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.github.theodorosB.therapath.data.user.UserDataSource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
): UserDataSource {

    override suspend fun registerUser(password: String, email: String, username: String): Boolean {

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

    override suspend fun signInUser(username: String, password: String): Boolean {

        return try {

            val email = getEmailByUsername(username) ?: return false
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    private suspend fun getEmailByUsername(username: String): String? {

        val result = firestore.collection(USERS)
            .whereEqualTo(USERNAME, username)
            .get()
            .await()

        return result.documents.firstOrNull()
            ?.getString(EMAIL)
    }

    companion object {
        const val USERS = "users"
        const val USERNAME = "username"
        const val EMAIL = "email"
    }
}