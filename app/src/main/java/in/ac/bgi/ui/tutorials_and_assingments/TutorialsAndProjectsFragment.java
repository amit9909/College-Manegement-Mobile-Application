package in.ac.bgi.ui.tutorials_and_assingments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import in.ac.bgi.databinding.FragmentTutorialsAndProjectsBinding;

public class TutorialsAndProjectsFragment extends Fragment {

    private FragmentTutorialsAndProjectsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TutorialsAndProjectsViewModel tutorialsAndProjectsViewModel =
                new ViewModelProvider(this).get(TutorialsAndProjectsViewModel.class);

        binding = FragmentTutorialsAndProjectsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTutorialsAndProjects;
        tutorialsAndProjectsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}