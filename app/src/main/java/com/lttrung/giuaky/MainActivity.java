package com.lttrung.giuaky;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.lttrung.giuaky.databinding.ActivityMainBinding;
import com.lttrung.giuaky.ui.dashboard.DashboardFragment;
import com.lttrung.giuaky.ui.home.HomeFragment;
import com.lttrung.giuaky.ui.user.UserFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

//    private NavigationBarView.OnItemSelectedListener navigationItemListener = item -> {
//        switch (item.getItemId()) {
//            case R.id.navigation_home: {
//                getSupportActionBar().setTitle(getString(R.string.title_home));
//                switchFragment(new HomeFragment());
//            }
//            case R.id.navigation_dashboard: {
//                getSupportActionBar().setTitle(getString(R.string.title_dashboard));
//                switchFragment(new DashboardFragment());
//            }
//            case R.id.navigation_user: {
//                getSupportActionBar().setTitle(getString(R.string.title_user));
//                switchFragment(new UserFragment());
//            }
//        }
//        return false;
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        binding.navView.setOnItemSelectedListener(navigationItemListener);
    }

    private void switchFragment(Fragment fragment) {
        // Create new fragment and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);

        // Replace whatever is in the fragment_container view with this fragment
        transaction.add(fragment, fragment.getClass().getName());

        // Commit the transaction
        transaction.commit();
    }

}