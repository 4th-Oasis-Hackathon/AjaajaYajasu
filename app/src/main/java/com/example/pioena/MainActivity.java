package com.example.pioena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(
                item -> {
                    int itemId = item.getItemId();
                    if (itemId == R.id.tab1) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                        return true;
                    } else if (itemId == R.id.tab2) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                        return true;
                    } else if (itemId == R.id.tab3) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                        return true;
                    } else if (itemId == R.id.tab4) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment4).commit();
                        return true;
                    } else if (itemId == R.id.tab5) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment5).commit();
                        return true;
                    }
                    return false;
                }
        );
    }

}