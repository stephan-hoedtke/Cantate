package com.stho.cantate;

import android.app.Activity;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.stho.cantate.ui.CantateFragment;
import com.stho.cantate.ui.CatholicDominicaFragment;
import com.stho.cantate.ui.HomeFragment;

import java.security.InvalidParameterException;

public class MainNavigator {

    private final Activity activity;
    private final MainViewModel viewModel;


    public static MainNavigator build(Activity activity) {
        return new MainNavigator(activity, null);
    }

    public static MainNavigator build(Activity activity, MainViewModel viewModel) {
        return new MainNavigator(activity, viewModel);
    }

    private MainNavigator(Activity activity, MainViewModel viewModel) {
        this.activity = activity;
        this.viewModel = viewModel;
    }

    public void openCantate(String bwv) {
        Bundle args = CantateFragment.createBundle(bwv);
        Navigation.findNavController(activity, R.id.nav_host_fragment)
                .navigate(R.id.navigation_cantate, args, new NavOptions.Builder()
                        .setPopEnterAnim(R.anim.slide_in_right)
                        .setPopExitAnim(R.anim.slide_out_left)
                        .setEnterAnim(R.anim.slide_in_left)
                        .setExitAnim(R.anim.slide_out_right)
                        .build());
    }

    public void openCatholicDominica(int position) {
        Bundle args = CatholicDominicaFragment.createBundle(position);
        Navigation.findNavController(activity, R.id.nav_host_fragment)
                .navigate(R.id.navigation_catholic_dominica, args, new NavOptions.Builder()
                        .setPopEnterAnim(R.anim.slide_in_right)
                        .setPopExitAnim(R.anim.slide_out_left)
                        .setEnterAnim(R.anim.slide_in_left)
                        .setExitAnim(R.anim.slide_out_right)
                        .build());
    }

    public void goBack() {
        NavController navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
        switch (navController.getCurrentDestination().getId()) {

            case R.id.navigation_home:
                // do not change if we are at the home screen. Don't move away from the current day.
                break;

            default:
                navController.popBackStack(R.id.navigation_home, false);
                navController.navigate(R.id.navigation_home);
                break;
        }
    }

    public void goHome() {
        if (viewModel != null) {
            viewModel.setCurrentPosition(HomePagerAdapter.START_POSITION);
        }
        goBack();
    }

    public void openSearch() {
        NavController navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
        if (navController.getCurrentDestination().getId() != R.id.navigation_search) {
            navController.navigate(R.id.navigation_search, null, new NavOptions.Builder()
                    .setPopEnterAnim(R.anim.slide_in_right)
                    .setPopExitAnim(R.anim.slide_out_left)
                    .setEnterAnim(R.anim.slide_in_left)
                    .setExitAnim(R.anim.slide_out_right)
                    .build());
        }
    }
}


