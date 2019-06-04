package com.google.appinventor.components.runtime;

import android.graphics.Color;
import android.view.View;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

import java.util.ArrayList;

@DesignerComponent(version = 1,
        category = ComponentCategory.CHARTS,
        description = "A component that allows visualizing data using bars")
@SimpleObject
public class BarChart extends ChartBase<com.github.mikephil.charting.charts.BarChart, BarData> {
    /**
     * Creates a new Bar Chart component.
     *
     * @param container container, component will be placed in
     */
    public BarChart(ComponentContainer container) {
        super(container);

        view = new com.github.mikephil.charting.charts.BarChart(container.$context());
        data = new BarData();
        view.setData(data);

        initChart();
    }

    @Override
    public View getView() {
        return view;
    }

    /**
     * Adds entry to the Line Data Series
     *
     * @param x - x value of entry
     * @param y - y value of entry
     */
    @SimpleFunction(description = "Adds (x, y) point to the Bar Data.")
    public void AddEntry(int x, int y) {
        BarEntry entry = new BarEntry(x, y);

        if (data.getDataSetCount() == 0) {
            BarDataSet dataSet = new BarDataSet(new ArrayList<BarEntry>(), "Data");
            dataSet.setColor(Color.BLACK);
            dataSet.addEntry(entry);
            data.addDataSet(dataSet);
        } else {
            data.getDataSetByIndex(0).addEntryOrdered(entry);
            data.notifyDataChanged();
        }

        Refresh();
    }
}
