// Generated by view binder compiler. Do not edit!
package com.firstapp.myapplication.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.firstapp.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStudentloginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final EditText studentemail;

  @NonNull
  public final Button studentlogin;

  @NonNull
  public final EditText studentpass;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  private ActivityStudentloginBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView4, @NonNull ProgressBar progressBar,
      @NonNull EditText studentemail, @NonNull Button studentlogin, @NonNull EditText studentpass,
      @NonNull TextView textView, @NonNull TextView textView5, @NonNull TextView textView6,
      @NonNull TextView textView7) {
    this.rootView = rootView;
    this.imageView4 = imageView4;
    this.progressBar = progressBar;
    this.studentemail = studentemail;
    this.studentlogin = studentlogin;
    this.studentpass = studentpass;
    this.textView = textView;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.textView7 = textView7;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentloginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentloginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_studentlogin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentloginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.studentemail;
      EditText studentemail = ViewBindings.findChildViewById(rootView, id);
      if (studentemail == null) {
        break missingId;
      }

      id = R.id.studentlogin;
      Button studentlogin = ViewBindings.findChildViewById(rootView, id);
      if (studentlogin == null) {
        break missingId;
      }

      id = R.id.studentpass;
      EditText studentpass = ViewBindings.findChildViewById(rootView, id);
      if (studentpass == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      return new ActivityStudentloginBinding((ConstraintLayout) rootView, imageView4, progressBar,
          studentemail, studentlogin, studentpass, textView, textView5, textView6, textView7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}