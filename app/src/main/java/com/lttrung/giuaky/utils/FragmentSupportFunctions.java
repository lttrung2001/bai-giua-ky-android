package com.lttrung.giuaky.utils;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lttrung.giuaky.R;

import java.util.Objects;

public class FragmentSupportFunctions {
    public static void replaceFragment(AppCompatActivity activity, Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment f = isFragmentInBackstack(fragmentManager, fragment.getClass().getName());
        if (f == null) {
            f = fragment;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_main, f);
        transaction.addToBackStack(f.getClass().getName());
        transaction.commit();
    }

    private static Fragment isFragmentInBackstack(FragmentManager fragmentManager, String fragmentName) {
        Fragment fragment;
        if (fragmentManager.getBackStackEntryCount() > 0) {
            for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(i);
                if (Objects.equals(backStackEntry.getName(), fragmentName)) {
                    // The fragment is in the back stack
                    fragment = fragmentManager.findFragmentByTag(fragmentName);
                    fragmentManager.popBackStack(fragmentName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return fragment;
                }
            }
        }
        return null;
    }
}
