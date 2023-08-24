package com.example.pioena;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.pioena.databinding.SlideItemBinding;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private static final String TAG = "SliderAdapter";

    private Context mContext;
    private List<Integer> sliderItems;
    private ViewPager2 mViewPager2;

    public SliderAdapter(Context context, ViewPager2 vpImageSlider, List<Integer> sliderImage) {
        mContext = context;
        mViewPager2 = vpImageSlider;
        this.sliderItems = sliderImage;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(SlideItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.bind(sliderItems.get(position));
        if (position == sliderItems.size() - 2) {
            mViewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private SlideItemBinding mBinding;
        public SliderViewHolder(SlideItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(Integer sliderItem) {
            try {
                Glide.with(mContext).load(sliderItem).into(mBinding.imageSlider);
            } catch (Exception e) {
                Log.d(TAG, "ERROR: " + e.getMessage());
            }
        }
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };
}
