package com.example.pioena;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.pioena.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment { // 홈
    private List<Integer> sliderItems = new ArrayList<>();
    private ViewPager2 vpImageSlider;
    private SliderAdapter sliderAdapter;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        sliderItems.add(R.drawable.rotate_flower1);
        sliderItems.add(R.drawable.rotate_flower2);
        sliderItems.add(R.drawable.rotate_flower3);
        vpImageSlider = rootView.findViewById(R.id.vp_image_slider);
        sliderAdapter = new SliderAdapter(requireContext(), vpImageSlider, sliderItems);
        vpImageSlider.setAdapter(sliderAdapter);

        return rootView;
    }
}
