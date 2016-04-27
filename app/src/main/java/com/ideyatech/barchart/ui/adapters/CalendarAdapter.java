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

import com.ideyatech.barchart.R;
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

        TextView txtValueOfAny;
        TextView txtAny;

    }

    /**
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
            holder.txtAny = (TextView) convertView.findViewById(R.id.any);
            holder.txtValueOfAny = (TextView) convertView.findViewById(R.id.valueOfAny);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        DashboardCalendarData listItem = (DashboardCalendarData) getItem(position);

        holder.txtAny.setText((String)listItem.getA());
        holder.txtValueOfAny.setText((String)listItem.getV());


        return convertView;
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return dashboardRowItems.size();
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return dashboardRowItems.get(position);
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return dashboardRowItems.indexOf(getItem(position));
    }
}