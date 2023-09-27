package air.texnodev.aphorismsapp.model;

import androidx.fragment.app.Fragment;

import air.texnodev.aphorismsapp.view.AphorsmFragment;

public class FremModel {

    private Fragment fragment;

    public FremModel(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
