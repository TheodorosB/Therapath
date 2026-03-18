package io.github.theodorosB.therapath.framework.user

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.github.theodorosB.therapath.data.user.UserDataSource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
): UserDataSource {

    override suspend fun registerUser(password: String, email: String, username: String) {
        val authResult = FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .await()

        val uid = authResult.user?.uid ?: return

        val userData = mapOf(
            "username" to username,
            "email" to email
        )

        firestore.collection("users")
            .document(uid)
            .set(userData)
            .addOnSuccessListener {
                Log.d(TAG, "User added successfully with Firebase UID: $uid")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding user with UID: $uid", e)
            }
    }
}