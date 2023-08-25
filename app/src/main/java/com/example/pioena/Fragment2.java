package com.example.pioena;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    GridView gridView;

    String[] numberWord = {"One", "Two", "Three", "Four", "Five", "Six"};

    int[] numberImage = {R.drawable.f1, R.drawable.f2, R.drawable.f3,
            R.drawable.f4, R.drawable.f5, R.drawable.f6};

    /**원데이 클래스 그리드 레이아웃 구현
     *  사진 클릭시 toast 발생
     *
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false);
        /*
        gridView = rootView.findViewById(R.id.gridView);

        NumberAdapter numberAdapter = new NumberAdapter(requireContext(), numberWord, numberImage);
        gridView.setAdapter(numberAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(requireContext(), numberWord[position] + "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });
           */
        return rootView;
    }

    //원데이 클래스 스피너 구현 // 에러 있음
    /*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Spinner
        Spinner rigionSpinner = view.findViewById(R.id.region);
        ArrayAdapter<CharSequence> regionAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.region, android.R.layout.simple_spinner_item);
        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rigionSpinner.setAdapter(regionAdapter);

        Spinner orderSpinner = view.findViewById(R.id.orderBy);
        ArrayAdapter<CharSequence> orderAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.orderBy, android.R.layout.simple_spinner_item);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(orderAdapter);

        Spinner daySpinner = view.findViewById(R.id.classDay);
        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.classDay, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        Spinner classSpinner = view.findViewById(R.id.classType);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.classType, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(typeAdapter);

        Spinner levelSpinner = view.findViewById(R.id.classLevel);
        ArrayAdapter<CharSequence> levelAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.classLevel, android.R.layout.simple_spinner_item);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);
    }
     */
}