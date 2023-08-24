package com.example.pioena;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); // customizing
        actionBar.setDisplayShowTitleEnabled(true); // 제목 보이게
        actionBar.setDisplayHomeAsUpEnabled(false); // 뒤로가기 버튼(true이면 생김)
        ImageButton imageButton = findViewById(R.id.search);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                SearchFragment searchFragment = new SearchFragment();
                transaction.replace(R.id.container, searchFragment);
                transaction.commit();
            }
        });

        loginFragment = new LoginFragment();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit(); // 처음에는 홈 화면
        bottomNavigation = findViewById(R.id.bottom_navigation);
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
    public void onTabSelected(int position) {
        if (position == 0) {
            bottomNavigation.setSelectedItemId(R.id.tab1);
        } else if (position == 1) {
            bottomNavigation.setSelectedItemId(R.id.tab2);
        } else if (position == 2) {
            bottomNavigation.setSelectedItemId(R.id.tab3);
        } else if (position == 3) {
            bottomNavigation.setSelectedItemId(R.id.tab4);
        } else if (position == 4) {
            bottomNavigation.setSelectedItemId(R.id.tab5);
        }
    }

}