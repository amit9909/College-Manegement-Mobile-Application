// Generated by view binder compiler. Do not edit!
package in.ac.bgi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import in.ac.bgi.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ContentBpmcStudentMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  private ContentBpmcStudentMainBinding(@NonNull ConstraintLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentBpmcStudentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentBpmcStudentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_bpmc_student_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentBpmcStudentMainBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ContentBpmcStudentMainBinding((ConstraintLayout) rootView);
  }
}
