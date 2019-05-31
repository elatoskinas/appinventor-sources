package com.google.appinventor.components.runtime;

import android.graphics.Color;
import android.view.View;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;

import java.util.ArrayList;

@DesignerComponent(version = 1,
    category = ComponentCategory.CHARTS,
    description = "A component that allows visualizing data using lines")
@SimpleObject
public final class LineChart extends ChartBase<com.github.mikephil.charting.charts.LineChart, LineData> {

    /**
     * Creates a new Line Chart component.
     *
     * @param container container, component will be placed in
     */
    public LineChart(ComponentContainer container) {
        super(container);

        view = new com.github.mikephil.charting.charts.LineChart(container.$context());
        data = new LineData();
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
    @SimpleFunction(description = "Adds (x, y) point to the Line Data.")
    public void AddEntry(int x, int y) {
        Entry entry = new Entry(x, y);

        // TBD: Multiple dataset support
        // For now, this stores all the data in one Data Set.
        // The reason for this if statement is because passing in a DataSet with
        // no entries will cause exceptions, so if there are no entries initially,
        // the ChartData object should have no DataSet attached to it.
        if (data.getDataSetCount() == 0) {
            LineDataSet dataSet = new LineDataSet(new ArrayList<Entry>(), "Data");
            dataSet.setColor(Color.BLACK);
            dataSet.setCircleColor(Color.BLACK);
            dataSet.addEntry(entry);
            data.addDataSet(dataSet);
        } else {
            data.getDataSetByIndex(0).addEntryOrdered(entry);
            data.notifyDataChanged();
            // chartData.addEntry(entry, 0);
        }

        Refresh();
    }
}
