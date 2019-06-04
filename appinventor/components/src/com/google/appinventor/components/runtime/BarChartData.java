package com.google.appinventor.components.runtime;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

import java.util.ArrayList;

@DesignerComponent(version = 1,
        description = "A component that holds data for Bar Charts",
        category = ComponentCategory.CHARTS,
        nonVisible = true,
        iconName = "images/web.png")
@SimpleObject
public final class BarChartData extends ChartDataBase<BarData> {
    /**
     * Creates a new Bar Chart Data component.
     *
     * @param form the container that this component will be placed in
     */
    public BarChartData(Form form) {
        super(form);

        // Instantiate new LineDataSet object
        chartData = new BarData();
    }

    /**
     * Adds entry to the Bar Data Series
     *
     * @param x - x value of entry
     * @param y - y value of entry
     */
    @SimpleFunction(description = "Adds (x, y) point to the Bar Data.")
    public void AddEntry(int x, int y) {
        BarEntry entry = new BarEntry(x, y);

        if (chartData.getDataSetCount() == 0) {
            BarDataSet dataSet = new BarDataSet(new ArrayList<BarEntry>(), "Data");
            dataSet.setColor(Color.BLACK);
            dataSet.addEntry(entry);
            chartData.addDataSet(dataSet);
        } else {
            chartData.getDataSetByIndex(0).addEntryOrdered(entry);
            chartData.notifyDataChanged();
        }

        refreshCharts();
    }
}

