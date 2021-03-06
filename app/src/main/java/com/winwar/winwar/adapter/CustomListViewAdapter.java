package com.winwar.winwar.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.winwar.winwar.R;
import com.winwar.winwar.context.ApplicationContextHolder;
import com.winwar.winwar.model.DetailStep;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<DetailStep> {

    private List<DetailStep> detailSteps;
    private Context mContext;
    private TypedArray imagesStep;

    public CustomListViewAdapter(List<DetailStep> detailSteps, @NonNull Context context, TypedArray typedArray){
        super(context, R.layout.custom_step_row, detailSteps);
        this.detailSteps = detailSteps;
        this.mContext = context;
        this.imagesStep = typedArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DetailStep detailStep = detailSteps.get(position);
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_step_row, parent, false);

            viewHolder.numberOfTheStep = convertView.findViewById(R.id.numberOfStep);
            viewHolder.contentOfStep = convertView.findViewById(R.id.contentOfStep);
            viewHolder.imageOfStep = convertView.findViewById(R.id.imageOfStep);

            convertView.setTag(viewHolder);
        } else {
           viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.numberOfTheStep.setText(String.valueOf(detailStep.getStep()));
        viewHolder.contentOfStep.setText(String.valueOf(detailStep.getContent()));
        viewHolder.imageOfStep.setImageResource(imagesStep.getResourceId(position,-1));

        return convertView;
    }

    private static class ViewHolder {
        TextView numberOfTheStep;
        TextView contentOfStep;
        ImageView imageOfStep;
    }
}
