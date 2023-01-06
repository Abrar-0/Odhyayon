package com.firstapp.myapplication.storage


import android.content.Context
import com.firstapp.myapplication.teachermodels


class SharedPrefManager private constructor(private val mCtx: Context) {

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getInt("ID", -1) != -1
        }

    val user: teachermodels
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return teachermodels(
                sharedPreferences.getInt("ID", -1),
                sharedPreferences.getString("First_name", null),
                sharedPreferences.getString("Last_name", null),
                sharedPreferences.getString("Email", null),
                sharedPreferences.getString("Phone_number", null),
                sharedPreferences.getString("Password", null),
                sharedPreferences.getString("Course_id", null),
                sharedPreferences.getString("Date_of_birth", null)
            )
        }


    fun saveUser(teachermodels: String) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("ID", user.ID)
        editor.putString("First_name", user.First_name)
        editor.putString("Last_name", user.Last_name)
        editor.putString("Email", user.Email)
        editor.putString("Phone_number", user.Phone_number)
        editor.putString("Password", user.Password)
        editor.putString("Course_id", user.Course_id)
        editor.putString("Date_of_birth", user.Date_of_birth)


        editor.apply()

    }

    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_preff"
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }

}