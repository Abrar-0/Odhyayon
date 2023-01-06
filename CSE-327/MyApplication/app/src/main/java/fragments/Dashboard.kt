package fragments
<<<<<<< HEAD

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import com.firstapp.myapplication.R
import com.firstapp.myapplication.usercheck_login
import android.support.v7.app.AppCompatActivity
import android.content.*
import android.support.v4.content.ContextCompat.startActivity
import com.firstapp.myapplication.teacherdash
import kotlinx.android.synthetic.main.activity_teacherdash.*
import kotlinx.android.synthetic.main.fragment_classroom.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.popupclass.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Dashboard.newInstance] factory method to
 * create an instance of this fragment.
 */
class Dashboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_dashboard, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)



         }
}
=======
//
//import android.app.AlertDialog
//import android.content.Intent
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.Toast.LENGTH_LONG
//import android.widget.Toast.makeText
//import com.firstapp.myapplication.R
//import com.firstapp.myapplication.usercheck_login
//import android.support.v7.app.AppCompatActivity
//import android.content.*
//import android.support.v4.content.ContextCompat.startActivity
//import com.firstapp.myapplication.teacherdash
//import kotlinx.android.synthetic.main.activity_teacherdash.*
//import kotlinx.android.synthetic.main.popupclass.view.*
//
//
//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [Dashboard.newInstance] factory method to
// * create an instance of this fragment.
// */
//class Dashboard : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        inflater.inflate(R.layout.fragment_dashboard, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
//
//
//
//        val button1= rootView.findViewById(R.id.addclassbutton3)
//
//    button1{
//        val intent = Intent(this, classroomadd::class.java)
//        startActivity(intent)
//    }
//    classroomadd.setOnClickListener {
//        //inflate the dialog with custom view
//        val mDialogView = LayoutInflater.from(this).inflate(R.layout.popupclass, null);
//        //alert dialog builder
//        val mBuilder = AlertDialog.Builder(this)
//            .setView(mDialogView)
//            .setTitle("Add Classroom")
//        //show dialog
//        val mAlertDialog = mBuilder.show()
//        //login button click
//        mDialogView.dialogclass.setOnClickListener {
//            //dismiss dialog
//            // mAlertDialog.dismiss()
//
//            //get text from edittexts
//            val course = mDialogView.dialogname.text.toString()
//            val code = mDialogView.dialogcode.text.toString()
//            val section = mDialogView.dialogsection.text.toString()
//            classinfo.setText("Course Name:" + course + "\nCourse Code:" + code + "\nCourse Section:" + section)
//
//
//        }
//    }}}
>>>>>>> 160d6dd76daad12092f81ed0ea54029a8305fa9c
