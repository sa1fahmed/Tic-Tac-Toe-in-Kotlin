package com.example.inteli5.newdemo2

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.point.view.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.linearLayoutCompat
import org.jetbrains.anko.custom.customView

class MainActivity : AppCompatActivity() {

    var XorO = "X"
    var Xcount= 0
    var Ocount= 0
    var list = arrayOf("N","N","N","N","N","N","N","N","N")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1.setOnClickListener {
           if (list.get(0).equals("N")) {
               textView1.setText(XorO)
               list.set(0, XorO)
               check()
               change()
           }
        }

        textView2.setOnClickListener {
            if (list.get(1).equals("N")) {
            textView2.setText(XorO)
            list.set(1,XorO)
            check()
            change()
            }
        }
        textView3.setOnClickListener {
            if (list.get(2).equals("N")) {
            textView3.setText(XorO)
            list.set(2,XorO)
            check()

            change()
            }
        }
        textView4.setOnClickListener {
            if (list.get(3).equals("N")) {
                textView4.setText(XorO)
                list.set(3, XorO)
                check()
                change()
            }
        }
        textView5.setOnClickListener {
            if (list.get(4).equals("N")) {
            textView5.setText(XorO)
            list.set(4,XorO)
            check()

            change()
            }
        }
        textView6.setOnClickListener {
            if (list.get(5).equals("N")) {
            textView6.setText(XorO)
            list.set(5,XorO)
            check()
            change()
            }
        }
        textView7.setOnClickListener {
            if (list.get(6).equals("N")) {
            textView7.setText(XorO)
            list.set(6,XorO)
            check()
            change()
            }
        }
        textView8.setOnClickListener {
            if (list.get(7).equals("N")) {
                textView8.setText(XorO)
                list.set(7, XorO)
                check()
                change()
            }
        }
        textView9.setOnClickListener {
            if (list.get(8).equals("N")) {
                textView9.setText(XorO)
                list.set(8, XorO)
                check()
                change()
            }
        }
    }

    fun reset(){
        list = arrayOf("N","N","N","N","N","N","N","N","N")
        textView1.setText("")
        textView2.setText("")
        textView3.setText("")
        textView4.setText("")
        textView5.setText("")
        textView6.setText("")
        textView7.setText("")
        textView8.setText("")
        textView9.setText("")
    }

   fun check(){
       if ((list.get(0).equals("X")&&list.get(1).equals("X")&&list.get(2).equals("X")) || (list.get(3).equals("X")&&list.get(4).equals("X")&&list.get(5).equals("X")) || (list.get(6).equals("X")&&list.get(7).equals("X")&&list.get(8).equals("X"))||(list.get(0).equals("X")&&list.get(3).equals("X")&&list.get(6).equals("X"))||(list.get(1).equals("X")&&list.get(4).equals("X")&&list.get(7).equals("X"))||(list.get(2).equals("X")&&list.get(5).equals("X")&&list.get(8).equals("X"))||(list.get(0).equals("X")&&list.get(4).equals("X")&&list.get(8).equals("X"))||(list.get(2).equals("X")&&list.get(4).equals("X")&&list.get(6).equals("X")))
       {
           Xcount++
           val builder = AlertDialog.Builder(this)
           val inflater:View =  LayoutInflater.from(this).inflate(R.layout.point,null)
           builder.setView(inflater)
           builder.setTitle("X WIN!!!")
           inflater.textView11.setText(Xcount.toString())
           inflater.textView12.setText(Ocount.toString())
           builder.setPositiveButton("OK"){dialog, which ->
               dialog.dismiss()
               reset()
           }
           val dialog: AlertDialog = builder.create()
           dialog.setCanceledOnTouchOutside(false)

           dialog.show()
            }
       else if ((list.get(0).equals("O")&&list.get(1).equals("O")&&list.get(2).equals("O")) || (list.get(3).equals("O")&&list.get(4).equals("O")&&list.get(5).equals("O")) || (list.get(6).equals("O")&&list.get(7).equals("O")&&list.get(8).equals("O"))||(list.get(0).equals("O")&&list.get(3).equals("O")&&list.get(6).equals("O"))||(list.get(1).equals("O")&&list.get(4).equals("O")&&list.get(7).equals("O"))||(list.get(2).equals("O")&&list.get(5).equals("O")&&list.get(8).equals("O"))||(list.get(0).equals("O")&&list.get(4).equals("O")&&list.get(8).equals("O"))||(list.get(2).equals("O")&&list.get(4).equals("O")&&list.get(6).equals("O"))) {

           Ocount++
           val builder = AlertDialog.Builder(this)
           val inflater:View =  LayoutInflater.from(this).inflate(R.layout.point,null)
           builder.setView(inflater)
           builder.setTitle("O WIN!!!")
           builder.setPositiveButton("OK"){dialog, which ->
               dialog.dismiss()
               reset()
           }
           inflater.textView11.setText(Xcount.toString())
           inflater.textView12.setText(Ocount.toString())
           val dialog: AlertDialog = builder.create()
           builder.setPositiveButton("OK"){dialog, which ->
               dialog.dismiss()
           }
           dialog.show()
       }
       else if (!list.contains("N")){
           reset()
           val builder = AlertDialog.Builder(this)
           val inflater:View =  LayoutInflater.from(this).inflate(R.layout.point,null)
           builder.setView(inflater)
           builder.setTitle("DRAW!!!")
           builder.setPositiveButton("OK"){dialog, which ->
               dialog.dismiss()
               reset()
           }
           inflater.textView11.setText(Xcount.toString())
           inflater.textView12.setText(Ocount.toString())
           val dialog: AlertDialog = builder.create()
           builder.setPositiveButton("OK"){dialog, which ->
               dialog.dismiss()
           }
           dialog.show()
       }
   }

    private fun change() {
        if (XorO.equals("X")){
            XorO = "O"
        }
        else
            XorO = "X"
    }

}
