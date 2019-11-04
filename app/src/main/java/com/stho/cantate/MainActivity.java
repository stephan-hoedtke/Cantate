package com.stho.cantate;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stho.cantate.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main, null);

        // Prepare the main ViewModel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (mainViewModel.isNotPrepared()) {
            mainViewModel.prepare(new Data()
                    .prepareCantatas(getResources().getXml(R.xml.cantatas))
                    .prepareCatholic(getResources().getXml(R.xml.catholic))
                    .prepareEvangelic(getResources().getXml(R.xml.evangelic)));
        }

        // Setup Navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
