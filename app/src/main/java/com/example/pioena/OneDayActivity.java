package com.example.pioena;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class OneDayActivity extends AppCompatActivity {

    GridView gridView;

    String[] numberWord = {"One", "Two", "Three", "Four", "Five", "Six"};

    int[] numberImage = {R.drawable.f1, R.drawable.f2, R.drawable.f3,
            R.drawable.f4, R.drawable.f5, R.drawable.f6};

    /**원데이 클래스 그리드 레이아웃 구현
     *  사진 클릭시 toast 발생
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        gridView = findViewById(R.id.gridView);

        NumberAdapter numberAdapter = new NumberAdapter(OneDayActivity.this, numberWord, numberImage);
        gridView.setAdapter(numberAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), numberWord[position] + "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

    //원데이 클래스 스피너 구현
    //@Override
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi_header);

        // Spinner
        Spinner rigionSpinner = (Spinner) findViewById(R.id.region);
        ArrayAdapter regionAdapter = ArrayAdapter.createFromResource(this,
                R.array.region, android.R.layout.simple_spinner_item);
        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rigionSpinner.setAdapter(regionAdapter);

        Spinner orderSpinner = (Spinner) findViewById(R.id.orderBy);
        ArrayAdapter orderAdapter = ArrayAdapter.createFromResource(this,
                R.array.orderBy, android.R.layout.simple_spinner_item);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(orderAdapter);

        Spinner daySpinner = (Spinner) findViewById(R.id.classDay);
        ArrayAdapter dayAdapter = ArrayAdapter.createFromResource(this,
                R.array.classDay, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        Spinner classSpinner = (Spinner) findViewById(R.id.classType);
        ArrayAdapter typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.classType, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(typeAdapter);

        Spinner levelSpinner = (Spinner) findViewById(R.id.classLevel);
        ArrayAdapter levelAdapter = ArrayAdapter.createFromResource(this,
                R.array.classLevel, android.R.layout.simple_spinner_item);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);
    }

}