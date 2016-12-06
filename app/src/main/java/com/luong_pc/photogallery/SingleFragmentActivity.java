package com.luong_pc.photogallery;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by luongs3 on 10/28/2016.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @LayoutRes
    //@LayoutRes: tell Android Studio that any class override this method
    //should return resource id
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            // bind fragment with specific activity
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
