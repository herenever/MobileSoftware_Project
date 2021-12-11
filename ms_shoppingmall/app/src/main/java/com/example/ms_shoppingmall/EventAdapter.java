package com.example.ms_shoppingmall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class EventAdapter extends PagerAdapter {
    private Context mcontext = null;
    private ArrayList<Integer> imagelist;
    public EventAdapter() {

    }
    public EventAdapter(Context context, ArrayList<Integer> imageList){
        mcontext = context;
        imagelist = imageList;
    }

    @Override
    public int getCount() {
        return imagelist.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view =null;

        if (mcontext != null) {

            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.eventpage, container, false);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView) ;
            imageView.setImageResource(imagelist.get(position));
        }

        // 뷰페이저에 추가.
        container.addView(view) ;

        return view ;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }



}
