package br.com.pintos.depositoapp.tasks

import android.os.AsyncTask
import br.com.pintos.depositoapp.model.User
import java.net.URL


class LoginTask : AsyncTask<String, Int, User?>(){
    override fun doInBackground(vararg param: String?): User? {
        val userName = param.firstOrNull()
        val url = "http://localhost:8080/rest/users/name/$userName"
        val result = URL(url).readText()
return null
    }
}