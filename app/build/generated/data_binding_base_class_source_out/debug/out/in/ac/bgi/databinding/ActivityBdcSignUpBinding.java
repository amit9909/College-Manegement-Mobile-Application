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

public final class ActivityBdcSignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText BdcStudentSgnupStudentName;

  @NonNull
  public final EditText BdcStudentSignUpStudentEmailAddress;

  @NonNull
  public final EditText BdcStudentSignUpStudentPassword;

  @NonNull
  public final EditText BdcStudentSignUpStudentRollNumber;

  @NonNull
  public final Button BdcStudentSignUpStudentSignUpbtn;

  @NonNull
  public final TextView BdcStudentSignuptext;

  private ActivityBdcSignUpBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText BdcStudentSgnupStudentName,
      @NonNull EditText BdcStudentSignUpStudentEmailAddress,
      @NonNull EditText BdcStudentSignUpStudentPassword,
      @NonNull EditText BdcStudentSignUpStudentRollNumber,
      @NonNull Button BdcStudentSignUpStudentSignUpbtn, @NonNull TextView BdcStudentSignuptext) {
    this.rootView = rootView;
    this.BdcStudentSgnupStudentName = BdcStudentSgnupStudentName;
    this.BdcStudentSignUpStudentEmailAddress = BdcStudentSignUpStudentEmailAddress;
    this.BdcStudentSignUpStudentPassword = BdcStudentSignUpStudentPassword;
    this.BdcStudentSignUpStudentRollNumber = BdcStudentSignUpStudentRollNumber;
    this.BdcStudentSignUpStudentSignUpbtn = BdcStudentSignUpStudentSignUpbtn;
    this.BdcStudentSignuptext = BdcStudentSignuptext;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBdcSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBdcSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bdc_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBdcSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.BdcStudentSgnupStudentName;
      EditText BdcStudentSgnupStudentName = ViewBindings.findChildViewById(rootView, id);
      if (BdcStudentSgnupStudentName == null) {
        break missingId;
      }

      id = R.id.BdcStudentSignUpStudentEmailAddress;
      EditText BdcStudentSignUpStudentEmailAddress = ViewBindings.findChildViewById(rootView, id);
      if (BdcStudentSignUpStudentEmailAddress == null) {
        break missingId;
      }

      id = R.id.BdcStudentSignUpStudentPassword;
      EditText BdcStudentSignUpStudentPassword = ViewBindings.findChildViewById(rootView, id);
      if (BdcStudentSignUpStudentPassword == null) {
        break missingId;
      }

      id = R.id.BdcStudentSignUpStudentRollNumber;
      EditText BdcStudentSignUpStudentRollNumber = ViewBindings.findChildViewById(rootView, id);
      if (BdcStudentSignUpStudentRollNumber == null) {
        break missingId;
      }

      id = R.id.BdcStudentSignUpStudentSignUpbtn;
      Button BdcStudentSignUpStudentSignUpbtn = ViewBindings.findChildViewById(rootView, id);
      if (BdcStudentSignUpStudentSignUpbtn == null) {
        break missingId;
      }

      id = R.id.BdcStudentSignuptext;
      TextView BdcStudentSignuptext = ViewBindings.findChildViewById(rootView, id);
      if (BdcStudentSignuptext == null) {
        break missingId;
      }

      return new ActivityBdcSignUpBinding((ConstraintLayout) rootView, BdcStudentSgnupStudentName,
          BdcStudentSignUpStudentEmailAddress, BdcStudentSignUpStudentPassword,
          BdcStudentSignUpStudentRollNumber, BdcStudentSignUpStudentSignUpbtn,
          BdcStudentSignuptext);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
