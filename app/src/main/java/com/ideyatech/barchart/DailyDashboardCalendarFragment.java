package com.ideyatech.barchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.ideyatech.barchart.ui.adapters.CalendarAdapter;
import com.ideyatech.barchart.ui.beans.DashboardCalendarData;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class DailyDashboardCalendarFragment extends Fragment implements IDashboardCalendarFragment {






    /**
     *
     */
    public DailyDashboardCalendarFragment() {
        // Required empty public constructor
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_daily_dashboard,container,false);

        BarChart chart = (BarChart) v.findViewById(R.id.dailychart);

        // Get X Values and Get Data
        BarData data = new BarData(getXAxisValues(),getDataSet());

        //Get Legend and Disable Legend
        Legend l = chart.getLegend();
        l.setEnabled(false);

        // Config of Chart
        chart.setDescription(null);
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.setDrawGridBackground(false);
        chart.setScrollContainer(false);
        chart.setPinchZoom(false);
        chart.invalidate();
        chart.setTouchEnabled(false);
        chart.setClickable(false);
        chart.setDrawMarkerViews(false);
        chart.setDrawGridBackground(false);
        chart.setVerticalFadingEdgeEnabled(true);

        ListView listView;
        List <DashboardCalendarData> dashboardRowItems;

        dashboardRowItems = new ArrayList<DashboardCalendarData>();
        dashboardRowItems.add(new DashboardCalendarData("1AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("2AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("3AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("4AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("5AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("6AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("7AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("8AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("9AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("10AM","122"));
        dashboardRowItems.add(new DashboardCalendarData("11AM","122"));
        dashboardRowItems.add(new DashboardCalendarData("12AM", "122"));


        listView = (ListView)  v.findViewById(R.id.dailylist);
        CalendarAdapter adapter = new CalendarAdapter(getActivity().getBaseContext(), dashboardRowItems);
        listView.setAdapter(adapter);

        return v;
    }

    /**
     * Y
     * @return
     */
    private ArrayList<BarDataSet> getDataSet() {

        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry am1 = new BarEntry(600, 0);
        valueSet1.add(am1);
        BarEntry am2 = new BarEntry(100, 1);
        valueSet1.add(am2);
        BarEntry am3 = new BarEntry(500, 2);
        valueSet1.add(am3);
        BarEntry am4 = new BarEntry(300, 3);
        valueSet1.add(am4);
        BarEntry am5 = new BarEntry(200, 4);
        valueSet1.add(am5);
        BarEntry am6 = new BarEntry(800, 5);
        valueSet1.add(am6);
        BarEntry am7 = new BarEntry(400, 6);
        valueSet1.add(am7);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, null);
        // Color Green
        barDataSet1.setColor(Color.rgb(60,179,113));


        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    /**
     * X
     * @return
     */
    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("4/1");
        xAxis.add("4/2");
        xAxis.add("4/3");
        xAxis.add("4/4");
        xAxis.add("4/5");
        xAxis.add("4/6");
        xAxis.add("4/7");

        return xAxis;
    }


}