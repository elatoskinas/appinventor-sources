package com.google.appinventor.components.runtime;

import com.github.mikephil.charting.charts.Chart;
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
        description = "A component that holds data for Pie Charts",
        category = ComponentCategory.CHARTS,
        nonVisible = true,
        iconName = "images/web.png")
@SimpleObject
public class PieChartData extends ChartDataBase<PieData> {
    /**
     * Creates a new Pie Chart Data component.
     *
     * @param form the container that this component will be placed in
     */
    public PieChartData(Form form) {
        super(form);

        // Instantiate new LineDataSet object
        chartData = new PieData();
    }

    /**
     * Adds value to the Pie Chart
     *
     * @param value  Value of entry
     */
    @SimpleFunction(description = "Adds y value to the Pie Data.")
    public void AddValue(String label, int value) {
        PieEntry entry = new PieEntry(value, label);

        if (chartData.getDataSetCount() == 0) {
            PieDataSet dataSet = new PieDataSet(new ArrayList<PieEntry>(), "Data");
            dataSet.setColors(ColorTemplate.PASTEL_COLORS);
            dataSet.addEntry(entry);
            chartData.addDataSet(dataSet);
            chartData.setDrawValues(false);

            // There is an issue with Pie Chart Data, where if a Pie Data object with
            // an empty data set is passed into a Pie Chart, errors occur.
            // As such, the Pie Data object should only be assigned if it has at least
            // one non-empty data set.
            for (ChartBase chart : charts) {
                ((Chart)chart.getView()).setData(chartData); // safe cast
            }
        } else {
            chartData.addEntry(entry, 0);
            chartData.notifyDataChanged();
        }

        refreshCharts();
    }
}
