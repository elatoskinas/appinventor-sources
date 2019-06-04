package com.google.appinventor.components.runtime;

import android.graphics.Color;
import android.view.View;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;

import java.util.ArrayList;

@DesignerComponent(version = 1,
        category = ComponentCategory.CHARTS,
        description = "A component that allows visualizing data using pie slices")
@SimpleObject
public class PieChart extends ChartBase<com.github.mikephil.charting.charts.PieChart, PieChartData> {
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

        initChart();
    }

    @Override
    public View getView() {
        return view;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR,
            description = "")
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COMPONENT + ":com.google.appinventor.components.runtime.PieChartData")
    public void ChartData(PieChartData data) {
        // Remove this Chart from previous PieChartData component
        if (data != null) {
            data.removeChart(this);
        }

        // Add Chart to LineChartData component
        data.addChart(this);

        this.data = data;
        if (data.getChartData().getDataSetCount() > 0) { // Adding a PieData object with no (or empty) data sets results in a crash
            view.setData(this.data.getChartData());
        }
        view.invalidate();
    }
}
