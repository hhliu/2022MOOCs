package cycu.nclab.proj.a2022moocs.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import cycu.nclab.proj.a2022moocs.R;
import cycu.nclab.proj.a2022moocs.databinding.FragmentTabbedBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentTabbedBinding binding;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentTabbedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        uiInit(root);

        return root;
    }

    private void uiInit(View root) {
        int Index = 1;
        if (getArguments() != null) {
            Index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        final TextView textView = binding.sectionLabel;
        int finalIndex = Index;
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                switch (finalIndex) {
                    case 1:
                        root.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        root.setBackgroundColor(Color.GRAY);
                        break;
                    case 3:
                        root.setBackgroundColor(Color.GREEN);
                        break;
                    case 4:
                        root.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}