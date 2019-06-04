package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.gwt.resources.client.ImageResource;
import org.pepstock.charba.client.BarChart;
import org.pepstock.charba.client.data.BarDataset;
import org.pepstock.charba.client.resources.EmbeddedResources;
import org.pepstock.charba.client.resources.ResourcesType;

public final class MockBarChart extends MockChart<BarChart> {
    private static final String PROPERTY_DESCRIPTION = "Description";

    public static final String TYPE = "BarChart";

    /**
     * Creates a new instance of a Mock Bar Chart component.
     *
     * @param editor editor of source file the component belongs to
     */
    public MockBarChart(SimpleEditor editor) {
        super(editor, TYPE, images.image());

        chartWidget = new BarChart();

        loadTestData();

        initChart();
    }

    /**
     * Loads a test data set for the Bar Chart widget.
     */
    private void loadTestData() {
        // Initialize data set
        BarDataset dataset = chartWidget.newDataset();

        // Construct test data
        dataset.setData(1, 7, 5, 4);

        // Style settings
        dataset.setBorderColor("black");
        dataset.setBackgroundColor("black");
        dataset.setBorderWidth(1);
        dataset.setLabel("Data");

        // Set the data set to the chart
        chartWidget.getData().setDatasets(dataset);

        // Set x value labels
        chartWidget.getData().setLabels("1", "2", "3", "4");
    }
}