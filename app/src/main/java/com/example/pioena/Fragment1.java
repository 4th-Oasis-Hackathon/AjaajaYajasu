package com.example.pioena;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.pioena.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment { // 홈
    private List<String> sliderItems = new ArrayList<>();
    private ViewPager2 vpImageSlider;
    private SliderAdapter sliderAdapter;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        List<String> sliderItems = new ArrayList<>();
        sliderItems.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png");
        sliderItems.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg");
        vpImageSlider = rootView.findViewById(R.id.vp_image_slider);
        sliderAdapter = new SliderAdapter(requireContext(), sliderItems);
        vpImageSlider.setAdapter(sliderAdapter);

        return rootView;
    }
}
