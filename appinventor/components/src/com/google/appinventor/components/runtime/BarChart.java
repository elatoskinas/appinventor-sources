package com.google.appinventor.components.runtime;

import android.graphics.Color;
import android.view.View;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;

import java.util.ArrayList;

@DesignerComponent(version = 1,
        category = ComponentCategory.CHARTS,
        description = "A component that allows visualizing data using bars")
@SimpleObject
public class BarChart extends ChartBase<com.github.mikephil.charting.charts.BarChart, BarChartData> {
    /**
     * Creates a new Bar Chart component.
     *
     * @param container container, component will be placed in
     */
    public BarChart(ComponentContainer container) {
        super(container);

        view = new com.github.mikephil.charting.charts.BarChart(container.$context());

        initChart();
    }

    @Override
    public View getView() {
        return view;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR,
            description = "")
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COMPONENT + ":com.google.appinventor.components.runtime.BarChartData")
    public void ChartData(BarChartData data) {
        // Remove this Chart from previous BarChartData component
        if (data != null) {
            data.removeChart(this);
        }

        // Add Chart to LineChartData component
        data.addChart(this);

        this.data = data;
        view.setData(this.data.getChartData());
        view.invalidate();
    }
}
