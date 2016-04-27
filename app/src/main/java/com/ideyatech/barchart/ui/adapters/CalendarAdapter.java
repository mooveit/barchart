package com.ideyatech.barchart.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ideyatech.barchart.ui.beans.DashboardCalendarData;


import java.util.List;

/**
 *
 */
public class CalendarAdapter extends BaseAdapter {
    
    Context context;
    List<DashboardCalendarData> dashboardRowItems;

    /**
     *
     * @param context
     * @param items
     */
    public CalendarAdapter(Context context, List<DashboardCalendarData> items) {
        this.context = context;
        this.dashboardRowItems = items;
    }

    /**
     *
     */
    private class ViewHolder {
        ImageView imageView;
        TextView txtValue;
        TextView txtRewardComment;
        ImageView border;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtRewardComment = (TextView) convertView.findViewById(R.id.desc);
            holder.txtValue = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            holder.border = (ImageView) convertView.findViewById(R.id.border);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        DashboardRowItem dashboardRowItem = (DashboardRowItem) getItem(position);

        holder.txtRewardComment.setText(dashboardRowItem.getRewardComment());
        holder.txtValue.setText(dashboardRowItem.getValue());
        holder.txtRewardComment.setTypeface(null, Typeface.ITALIC);
        holder.imageView.setImageResource(dashboardRowItem.getImageId());
        holder.border.setImageResource(R.drawable.fading_line);

        return convertView;
    }

    @Override
    public int getCount() {
        return dashboardRowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dashboardRowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dashboardRowItems.indexOf(getItem(position));
    }
}