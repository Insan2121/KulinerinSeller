package com.example.kulinerinseller.features.mainscreen;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.kulinerinseller.R;
import com.example.kulinerinseller.features.mainscreen.account.AccountFragment;
import com.example.kulinerinseller.features.mainscreen.chat.ChatFragment;
import com.example.kulinerinseller.features.mainscreen.notification.NotificationFragment;
import com.example.kulinerinseller.features.mainscreen.product.ProductFragment;
import com.example.kulinerinseller.features.mainscreen.statistic.StatisticFragment;

public class MainScreenActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment;
    private static MainScreenActivity mainScreenActivity;
    public static int selectedMenuId;

    public static MainScreenActivity getInstance() {
        return mainScreenActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mainScreenActivity = this;

        selectedMenuId = R.id.menu_statistic;

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_statistic:
                        selectedFragment = new StatisticFragment();
                        break;
                    case R.id.menu_chat:
                        selectedFragment = new ChatFragment();
                        break;
                    case R.id.menu_product:
                        selectedFragment = new ProductFragment();
                        break;
                    case R.id.menu_notifcation:
                        selectedFragment = new NotificationFragment();
                        break;
                    case R.id.menu_account:
                        selectedFragment = new AccountFragment();
                        break;
                }

                selectedMenuId = menuItem.getItemId();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, selectedFragment);
                fragmentTransaction.commit();
                return true;
            }
        });
    }

    public static int getId(int i) {
        return i == 0
                ? R.id.menu_statistic
                : i == 1
                ? R.id.menu_chat
                : i == 2
                ? R.id.menu_product
                : i == 3
                ? R.id.menu_notifcation
                : R.id.menu_account;
    }

    public void setPage(int i) {
        bottomNavigationView.setSelectedItemId(getId(i));
    }

    @Override
    protected void onStart() {
        bottomNavigationView.setSelectedItemId(selectedMenuId);
        super.onStart();
    }

}
