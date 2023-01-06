package com.firstapp.myapplication

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.NavigationMenuItemView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.widget.Button
import com.firstapp.myapplication.storage.SharedPrefManager

import fragments.Classroom
import fragments.Dashboard
import fragments.Settings
import kotlinx.android.synthetic.main.activity_teacherdash.*
import kotlinx.android.synthetic.main.popupclass.*
import kotlinx.android.synthetic.main.popupclass.view.*


class teacherdash : AppCompatActivity() {
    private val dashboard = Dashboard()
    private val classroom= Classroom()
    private val settings= Settings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacherdash)
        replaceFragment(dashboard)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_dashboard -> replaceFragment(dashboard)
                R.id.ic_class -> replaceFragment(classroom)
                R.id.ic_account -> replaceFragment(settings)
            }
        true
        }
//        }
//          classroomadd.setOnClickListener {
//              //inflate the dialog with custom view
//            val mDialogView = LayoutInflater.from(this).inflate(R.layout.popupclass, null);
//              //alert dialog builder
//            val mBuilder = AlertDialog.Builder(this)
//                .setView(mDialogView)
//                .setTitle("Add Classroom")
//              //show dialog
//            val mAlertDialog = mBuilder.show()
//              //login button click
//              mDialogView.dialogclass.setOnClickListener {
//                  //dismiss dialog
//                 // mAlertDialog.dismiss()
//
//                  //get text from edittexts
//                 val course = mDialogView.dialogname.text.toString()
//                  val code = mDialogView.dialogcode.text.toString()
//                  val section = mDialogView.dialogsection.text.toString()
//               classinfo.setText("Course Name:"+ course +"\nCourse Code:"+ code +"\nCourse Section:" + section)
//
//
//
//
//              }
//        }

////    override fun onStart() {
////        super.onStart()
////        if (!SharedPrefManager.getInstance(this).isLoggedIn){
////            val intent = Intent(applicationContext, teacherlogin2::class.java)
////            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
////            startActivity(intent)
////
////        }
//
 }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }}
