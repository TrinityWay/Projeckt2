package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.core.view.isVisible
import com.example.project2.constance.Constance
import com.example.project2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding
    private var login :String = "empty"
    private var password :String = "empty"
    private var name :String = "empty"
    private var name1 :String = "empty"
    private var name3 :String = "empty"
    private var avatarImageId :Int = 0



    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)




        }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Constance.REQUEST_CODE_SING_IN){
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            if(login == l && password == p ){

                bindingClass.imAvatar.visibility = VISIBLE
                bindingClass.imAvatar.setImageResource(avatarImageId)
                val textInfo = "$name $name1 $name3"
                bindingClass.tvInfo.text = textInfo
                bindingClass.bHide.visibility = GONE
                bindingClass.bExit.text = "ВЫЙТИ"
            }else{
                bindingClass.imAvatar.visibility = VISIBLE
                bindingClass.imAvatar.setImageResource(R.drawable.dula)
                bindingClass.tvInfo.text = "ТАКОГО АККАУНТА НЕ СУЩЕСТВУЕТ!"
            }
        }else if (requestCode == Constance.REQUEST_CODE_SING_UP){
            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASSWORD)!!
            name = data.getStringExtra(Constance.NAME)!!
            name1 = data.getStringExtra(Constance.NAME1)!!
            name3  = data.getStringExtra(Constance.NAME3)!!
            avatarImageId  = data.getIntExtra(Constance.AVATAR_ID, 0)
            bindingClass.imAvatar.visibility = VISIBLE
            bindingClass.imAvatar.setImageResource(avatarImageId)
            val textInfo = "$name $name1 $name3"
            bindingClass.tvInfo.text = textInfo
            bindingClass.bHide.visibility = GONE
            bindingClass.bExit.text = "ВЫЙТИ"



        }
    }

    fun onClickSingIn(view:View){
        if(bindingClass.imAvatar.isVisible){
            bindingClass.imAvatar.visibility= INVISIBLE
            bindingClass.tvInfo.text = ""
            bindingClass.bHide.visibility = View.VISIBLE
            bindingClass.bExit.text = getString(R.string.sing_in)

        } else{
        val intent = Intent(this, SinginUpAct::class.java)
        intent.putExtra(Constance.SING_STATE, Constance.SING_IN_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SING_IN)}


    }
    fun onClickSingUp(view:View){
        val intent = Intent(this, SinginUpAct::class.java)
        intent.putExtra(Constance.SING_STATE, Constance.SING_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SING_UP)

    }
    }




