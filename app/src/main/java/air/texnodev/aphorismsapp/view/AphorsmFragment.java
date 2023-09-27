package air.texnodev.aphorismsapp.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.Random;

import air.texnodev.aphorismsapp.R;
import air.texnodev.aphorismsapp.databinding.FragmentAphorsmBinding;
import air.texnodev.aphorismsapp.model.Quote;
import air.texnodev.aphorismsapp.network.CallApi;
import air.texnodev.aphorismsapp.network.NetWorking;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AphorsmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AphorsmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AphorsmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AphorsmFragment newInstance(String param1, String param2) {
        AphorsmFragment fragment = new AphorsmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.d("TAG_LIFE", "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG_LIFE", "onCreate: ");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private FragmentAphorsmBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAphorsmBinding.inflate(getLayoutInflater(), container, false);
        Log.d("TAG_LIFE", "onCreateView: ");

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Random random = new Random();
        int rand = 1 + random.nextInt(100);

        Log.d("TAGME", "onViewCreated: " + rand);
        Glide.with(this)
                .load("https://source.unsplash.com/random/1080x2340?sig=" + rand)
                .error(R.drawable.img)
                .into(binding.actionImage);

        CallApi api = NetWorking.getRetrofitInstance().create(CallApi.class);
        api.getAphorisms().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                Log.d("TAG_LIFE", "onResponse: " + response.body().getQuote());
                binding.actionImage.setVisibility(View.VISIBLE);
                binding.text.setText(response.body().getQuote());
                binding.text.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {

            }
        });

    }
}