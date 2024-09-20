package in.ac.bgi.ui.attendence;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import in.ac.bgi.databinding.FragmentAttendenceBinding;

public class AttendenceFragment extends Fragment {

    private FragmentAttendenceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AttendenceViewModel attendenceViewModel =
                new ViewModelProvider(this).get(AttendenceViewModel.class);

        binding = FragmentAttendenceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAttendence;
        attendenceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}