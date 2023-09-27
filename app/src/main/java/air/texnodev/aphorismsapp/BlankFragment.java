package air.texnodev.aphorismsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import air.texnodev.aphorismsapp.adapter.PagerAdapter;
import air.texnodev.aphorismsapp.databinding.FragmentBlankBinding;
import air.texnodev.aphorismsapp.model.FremModel;
import air.texnodev.aphorismsapp.view.AphorsmFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentBlankBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    private  List<FremModel> fragments;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragments = new ArrayList<>();
        fragments.add(new FremModel(new AphorsmFragment()));
        fragments.add(new FremModel(new AphorsmFragment()));


        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(), getLifecycle(), fragments);
        binding.vpMain.setAdapter(adapter);

        binding.vpMain.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                fragments.add(new FremModel(new AphorsmFragment()));
                //binding.vpMain.setCurrentItem(binding.vpMain.getCurrentItem() + 1);


                Log.d("TAG_GO", "onLayoutChange: "+ view.toString());
                Log.d("TAG_GO", "onLayoutChange: i "+ i);
                Log.d("TAG_GO", "onLayoutChange: i1 "+ i1);
                Log.d("TAG_GO", "onLayoutChange:  i2 "+ i2);
                Log.d("TAG_GO", "onLayoutChange:  i3 "+ i3);
                Log.d("TAG_GO", "onLayoutChange:  i4 "+ i4);
                Log.d("TAG_GO", "onLayoutChange:  i5 "+ i5);
                Log.d("TAG_GO", "onLayoutChange:  i6 "+ i6);
                Log.d("TAG_GO", "onLayoutChange:  i7 "+ i7);
            }
        });


    }
}