package air.texnodev.aphorismsapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import air.texnodev.aphorismsapp.model.FremModel;


public class PagerAdapter extends FragmentStateAdapter {

    List<FremModel> fremModels;

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<FremModel> fremModels) {
        super(fragmentManager, lifecycle);

        this.fremModels = fremModels;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fremModels.get(position).getFragment();
    }

    @Override
    public int getItemCount() {
        return fremModels.size();
    }
}
