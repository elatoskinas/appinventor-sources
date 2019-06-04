package com.google.appinventor.components.runtime;

import android.graphics.Color;
import android.view.View;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

import java.util.ArrayList;

@DesignerComponent(version = 1,
        category = ComponentCategory.CHARTS,
        description = "A component that allows visualizing data using pie slices")
@SimpleObject
public class PieChart extends ChartBase<com.github.mikephil.charting.charts.PieChart, PieData> {
    /**
     * Creates a new Line Chart component.
     *
     * @param container container, component will be placed in
     */
    public PieChart(ComponentContainer container) {
        super(container);

        view = new com.github.mikephil.charting.charts.PieChart(container.$context());
        view.setHoleRadius(0);
        view.setTransparentCircleRadius(0);
        view.setDrawEntryLabels(false);
        data = new PieData();

        initChart();
    }

    @Override
    public View getView() {
        return view;
    }

    /**
     * Adds value to the Pie Chart
     *
     * @param value  Value of entry
     */
    @SimpleFunction(description = "Adds y value to the Pie Data.")
    public void AddValue(String label, int value) {
        PieEntry entry = new PieEntry(value, label);

        // TBD: Multiple dataset support
        // For now, this stores all the data in one Data Set.
        // The reason for this if statement is because passing in a DataSet with
        // no entries will cause exceptions, so if there are no entries initially,
        // the ChartData object should have no DataSet attached to it.
        if (data.getDataSetCount() == 0) {
            PieDataSet dataSet = new PieDataSet(new ArrayList<PieEntry>(), "Data");
            dataSet.setColors(ColorTemplate.PASTEL_COLORS);
            dataSet.addEntry(entry);
            data.addDataSet(dataSet);
            data.setDrawValues(false);
            view.setData(data);
        } else {
            data.addEntry(entry, 0);
            data.notifyDataChanged();
        }

        Refresh();
    }
}
