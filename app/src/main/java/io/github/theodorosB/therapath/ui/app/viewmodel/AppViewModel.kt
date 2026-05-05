package io.github.theodorosB.therapath.ui.app.viewmodel

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
) : BaseViewModel() {

    /*fun getGoogleSignInClient(context: Context): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context, gso)
    }*/
}