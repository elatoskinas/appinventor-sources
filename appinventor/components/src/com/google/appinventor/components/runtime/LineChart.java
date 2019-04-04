package com.google.appinventor.components.runtime;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;

import java.util.ArrayList;

@DesignerComponent(version = YaVersion.LINECHART_COMPONENT_VERSION,
        category = ComponentCategory.CHARTS,
        description = "Line Chart Description sample",
        iconName = "images/spinner.png")
@SimpleObject
public final class LineChart extends ChartComponent<com.github.mikephil.charting.charts.LineChart> {
    /**
     * Creates a new AndroidViewComponent.
     *
     * @param container container, component will be placed in
     */
    public LineChart(ComponentContainer container) {
        super(container);

        view = new com.github.mikephil.charting.charts.LineChart(container.$context());

        // Just for testing purposes, populate the Line Chart with 3 test values.
        LineData testData = new LineData();

        // Populate LineDataSet
        LineDataSet lineDataSet = new LineDataSet(new ArrayList<Entry>(), "Entries");
        lineDataSet.addEntry(new Entry(1, 1));
        lineDataSet.addEntry(new Entry(2, 2));
        lineDataSet.addEntry(new Entry(3, 3));

        // Add DataSet to LineData
        testData.addDataSet(lineDataSet);

        // Set Data to LineChart to the LineData test set
        view.setData(testData);

        ScaleXEnabled(true);
        initChart();
    }
}


