package br.com.pintos.depositoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.system.Os.bind
import android.util.Log
import android.view.View
import br.com.pintos.depositoapp.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.android.synthetic.main.activity_login.*

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun execLogin(view : View) {

        doAsync {
            R.layout.activity_login
            val userName = edtLoginName.text?:""
            val userPass = edtPassword.text?:""
            val url = "http://192.168.4.104:8080/rest/users/name/$userName"
            val result = URL(url).readText()
            uiThread {
                val mapper = jacksonObjectMapper()
                val user : User= mapper.readValue(result)
                val passw : String= userPass.toString()
                val passw2 : String= user.passw.toString()
                if(passw == passw2)
                    toast("Senha Ok")
                else
                    toast("Senha errada!!!")
            }
        }
    }
}
