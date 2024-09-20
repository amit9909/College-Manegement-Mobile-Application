package in.ac.bgi.ui.fees_and_dues;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import in.ac.bgi.databinding.FragmentFeesAndDuesBinding;

public class FeesAndDuesFragment extends Fragment {

    private FragmentFeesAndDuesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FeesAndDuesViewModel feesAndDuesViewModel =
                new ViewModelProvider(this).get(FeesAndDuesViewModel.class);

        binding = FragmentFeesAndDuesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        feesAndDuesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}