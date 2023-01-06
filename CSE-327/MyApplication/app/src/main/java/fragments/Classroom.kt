package fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.firstapp.myapplication.R
import kotlinx.android.synthetic.main.fragment_classroom.*
import kotlinx.android.synthetic.main.popupclass.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Classroom.newInstance] factory method to
 * create an instance of this fragment.
 */
class Classroom : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            val button1= getActivity()?.findViewById<Button>(R.id.addclassbutton)
            button1?.setOnClickListener {
                val intent = Intent(getActivity(), addclassbutton::class.java)
                startActivity(intent)
            }

            addclassbutton.setOnClickListener {
                //inflate the dialog with custom view
                val mDialogView = LayoutInflater.from(getActivity()).inflate(R.layout.popupclass, null);
                //alert dialog builder
                val mBuilder = AlertDialog.Builder(getActivity())
                    .setView(mDialogView)
                    .setTitle("Add Classroom")
                //show dialog
                val mAlertDialog = mBuilder.show()
                //login button click
                mDialogView.dialogclass.setOnClickListener {
                    //dismiss dialog
                    // mAlertDialog.dismiss()

                    //get text from edittexts
                    val course = mDialogView.dialogname.text.toString()
                    val code = mDialogView.dialogcode.text.toString()
                    val section = mDialogView.dialogsection.text.toString()

                    classinfo.setText("Course Name:" + course + "\nCourse Code:" + code + "\nCourse Section:" + section)

                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classroom, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Classroom.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Classroom().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}