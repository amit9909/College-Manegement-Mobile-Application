// Generated by view binder compiler. Do not edit!
package in.ac.bgi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.ac.bgi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityItiSignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText ItiStudentSgnupStudentName;

  @NonNull
  public final EditText ItiStudentSignUpStudentEmailAddress;

  @NonNull
  public final EditText ItiStudentSignUpStudentPassword;

  @NonNull
  public final EditText ItiStudentSignUpStudentRollNumber;

  @NonNull
  public final Button ItiStudentSignUpStudentSignUpbtn;

  @NonNull
  public final TextView ItiStudentSignuptext;

  private ActivityItiSignUpBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText ItiStudentSgnupStudentName,
      @NonNull EditText ItiStudentSignUpStudentEmailAddress,
      @NonNull EditText ItiStudentSignUpStudentPassword,
      @NonNull EditText ItiStudentSignUpStudentRollNumber,
      @NonNull Button ItiStudentSignUpStudentSignUpbtn, @NonNull TextView ItiStudentSignuptext) {
    this.rootView = rootView;
    this.ItiStudentSgnupStudentName = ItiStudentSgnupStudentName;
    this.ItiStudentSignUpStudentEmailAddress = ItiStudentSignUpStudentEmailAddress;
    this.ItiStudentSignUpStudentPassword = ItiStudentSignUpStudentPassword;
    this.ItiStudentSignUpStudentRollNumber = ItiStudentSignUpStudentRollNumber;
    this.ItiStudentSignUpStudentSignUpbtn = ItiStudentSignUpStudentSignUpbtn;
    this.ItiStudentSignuptext = ItiStudentSignuptext;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityItiSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityItiSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_iti_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityItiSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ItiStudentSgnupStudentName;
      EditText ItiStudentSgnupStudentName = ViewBindings.findChildViewById(rootView, id);
      if (ItiStudentSgnupStudentName == null) {
        break missingId;
      }

      id = R.id.ItiStudentSignUpStudentEmailAddress;
      EditText ItiStudentSignUpStudentEmailAddress = ViewBindings.findChildViewById(rootView, id);
      if (ItiStudentSignUpStudentEmailAddress == null) {
        break missingId;
      }

      id = R.id.ItiStudentSignUpStudentPassword;
      EditText ItiStudentSignUpStudentPassword = ViewBindings.findChildViewById(rootView, id);
      if (ItiStudentSignUpStudentPassword == null) {
        break missingId;
      }

      id = R.id.ItiStudentSignUpStudentRollNumber;
      EditText ItiStudentSignUpStudentRollNumber = ViewBindings.findChildViewById(rootView, id);
      if (ItiStudentSignUpStudentRollNumber == null) {
        break missingId;
      }

      id = R.id.ItiStudentSignUpStudentSignUpbtn;
      Button ItiStudentSignUpStudentSignUpbtn = ViewBindings.findChildViewById(rootView, id);
      if (ItiStudentSignUpStudentSignUpbtn == null) {
        break missingId;
      }

      id = R.id.ItiStudentSignuptext;
      TextView ItiStudentSignuptext = ViewBindings.findChildViewById(rootView, id);
      if (ItiStudentSignuptext == null) {
        break missingId;
      }

      return new ActivityItiSignUpBinding((ConstraintLayout) rootView, ItiStudentSgnupStudentName,
          ItiStudentSignUpStudentEmailAddress, ItiStudentSignUpStudentPassword,
          ItiStudentSignUpStudentRollNumber, ItiStudentSignUpStudentSignUpbtn,
          ItiStudentSignuptext);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
