package com.stho.cantate;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main, null);

        // Prepare the main ViewModel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (mainViewModel.isNotPrepared()) {
            mainViewModel.prepare(new Data()
                    .prepareCantatas(new CantateSqliteHelper(getBaseContext()))
                    //.prepareCantatas(getResources().getXml(R.xml.cantatas))
                    .prepareCatholic(getResources().getXml(R.xml.catholic))
                    .prepareEvangelic(getResources().getXml(R.xml.evangelic)));
        }

        // Setup Navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_search, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        MainNavigator.build(MainActivity.this, mainViewModel).goHome();
                        return true;

                    case R.id.navigation_search:
                        MainNavigator.build(MainActivity.this, mainViewModel).openSearch();
                        return true;
                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        MainNavigator.build(this).goBack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            MainNavigator.build(this).goBack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
