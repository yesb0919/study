package com.example.user.androidstudy;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.androidstudy.week10.CalendarActvity;
import com.example.user.androidstudy.week2.ViewPagerActivity;
import com.example.user.androidstudy.week4.FloatingViewstartActivity;
import com.example.user.androidstudy.week5.GalleryActivity;
import com.example.user.androidstudy.week7.WhatIsContextActivity;
import com.example.user.androidstudy.week7_5.ButterKnifeActivity;
import com.example.user.androidstudy.week8.SwipeViewActivity;
import com.example.user.androidstudy.week9.RealmTestActivity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junsu on 2017-05-17.
 */

public class StudyListAdapter extends RecyclerView.Adapter<StudyListAdapter.StudyViewHolder> {

    private final String TAG = "StudyListAdapter";

    private Context mContext;
    private LayoutInflater mInflater;

    private List<Class> studyList = new ArrayList<>();
    private Class[] studyArray = {
            ViewPagerActivity.class,
            FloatingViewstartActivity.class,
            GalleryActivity.class,
            WhatIsContextActivity.class,
            SwipeViewActivity.class,
            ButterKnifeActivity.class,
            RealmTestActivity.class,
            CalendarActvity.class,
    };

    public StudyListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);

        studyList.addAll(Arrays.asList(studyArray));
    }

    @Override
    public StudyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StudyViewHolder(mInflater.inflate(R.layout.item_study_viewholder, parent, false));
    }

    @Override
    public void onBindViewHolder(StudyViewHolder holder, int position) {
        holder.bind(studyList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount is called: " + studyList.size());
        return studyList.size();
    }

    class StudyViewHolder extends RecyclerView.ViewHolder {

        TextView studyTitleView;
        Class studyActivity;

        public StudyViewHolder(View itemView) {
            super(itemView);
            studyTitleView = (TextView) itemView.findViewById(R.id.study_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, studyActivity);
                    mContext.startActivity(intent);
                }
            });
        }

        private void bind(Class study) {
            studyActivity = study;
            studyTitleView.setText(study.getName());
        }
    }
}
