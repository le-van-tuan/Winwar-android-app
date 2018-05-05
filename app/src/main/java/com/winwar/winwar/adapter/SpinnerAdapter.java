package com.winwar.winwar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.winwar.winwar.R;

public class SpinnerAdapter extends ArrayAdapter<String> {

    private int[] spinnerImages;
    private String[] spinnerName;
    private Context mContext;


    public SpinnerAdapter(@NonNull Context context, int[] images, String[] spinnerName) {
        super(context, R.layout.custom_spinner_row);
        this.spinnerImages = images;
        this.spinnerName = spinnerName;
        this.mContext = context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return spinnerName.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spinner_row, parent, false);
            mViewHolder.mFlag = convertView.findViewById(R.id.ivFlag);
            mViewHolder.mPopulation = convertView.findViewById(R.id.tvPopulation);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mFlag.setImageResource(spinnerImages[position]);
        mViewHolder.mPopulation.setText(spinnerName[position]);

        return convertView;
    }

    private static class ViewHolder {
        ImageView mFlag;
        TextView mPopulation;
    }
}
