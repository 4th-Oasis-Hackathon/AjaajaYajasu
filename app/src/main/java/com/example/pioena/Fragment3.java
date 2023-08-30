package com.example.pioena;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Fragment3 extends Fragment { // 커뮤니티
    Fragment3_1 fragment3_1;
    Fragment3_2 fragment3_2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);
        /*
        fragment3_1 = new Fragment3_1();
        fragment3_2 = new Fragment3_2();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3_1).commit();

        TabLayout tabs = rootView.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("정보 공유"));
        tabs.addTab(tabs.newTab().setText("나의 꽃을 소개합니다"));
        */

        return rootView;
    }
}
