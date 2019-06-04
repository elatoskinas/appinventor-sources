package com.google.appinventor.client.editor.simple.components;


import com.google.appinventor.client.editor.simple.SimpleEditor;
import org.pepstock.charba.client.PieChart;
import org.pepstock.charba.client.data.PieDataset;

public final class MockPieChart extends MockChart<PieChart> {
    public static final String TYPE = "PieChart";

    /**
     * Creates a new instance of a Mock Line Chart component.
     *
     * @param editor editor of source file the component belongs to
     */
    public MockPieChart(SimpleEditor editor) {
        super(editor, TYPE, images.image());

        // Initialize Line Chart mock Widget
        chartWidget = new PieChart();

        chartWidget.getOptions().getLegend().getLabels().setBoxWidth(20);

        // Load test data set
        loadTestData();

        // Initialize the Chart
        initChart();
    }

    /**
     * Loads a test data set for the Line Chart widget.
     */
    private void loadTestData() {
        // Initialize data set
        PieDataset dataset = chartWidget.newDataset();

        // Construct test data
        dataset.setData(1, 7, 5, 4);

        // Style settings
        dataset.setBackgroundColor("red", "green", "blue", "yellow");
        dataset.setLabel("Data");

        // Set the data set to the chart
        chartWidget.getData().setDatasets(dataset);

        // Set x value labels
        chartWidget.getData().setLabels("Entry 1", "Entry 2", "Entry 3", "Entry 4");
    }

    @Override
    public void onPropertyChange(String propertyName, String newValue) {
        super.onPropertyChange(propertyName, newValue);
    }
}
