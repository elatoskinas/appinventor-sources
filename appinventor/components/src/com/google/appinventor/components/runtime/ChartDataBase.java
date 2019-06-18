package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
public abstract class ChartDataBase implements Component {
    protected ChartBase container;
    protected ChartModel chartModel;

    private String label;
    private int color;

    /**
     * Creates a new Chart Data component.
     */
    protected ChartDataBase(ChartBase chartContainer) {
        this.container = chartContainer;

        chartModel = chartContainer.createChartModel();

        // Set default values
        Color(Component.COLOR_BLACK);
        Label("");
    }

    /**
     * Returns the data series color as an alpha-red-green-blue integer.
     *
     * @return  background RGB color with alpha
     */
    @SimpleProperty(
            category = PropertyCategory.APPEARANCE)
    public int Color() {
        return color;
    }

    /**
     * Specifies the data series color as an alpha-red-green-blue integer.
     *
     * @param argb  background RGB color with alpha
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
            defaultValue = Component.DEFAULT_VALUE_COLOR_BLACK)
    @SimpleProperty
    public void Color(int argb) {
        color = argb;
        chartModel.setColor(color);
        refreshChart();
    }

    /**
     * Returns the label text of the data series.
     *
     * @return  label text
     */
    @SimpleProperty(
            category = PropertyCategory.APPEARANCE)
    public String Label() {
        return label;
    }

    /**
     * Specifies the text for the data series label.
     *
     * @param text  label text
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
            defaultValue = "")
    @SimpleProperty
    public void Label(String text) {
        this.label = text;
        chartModel.setLabel(text);
        refreshChart();
    }

    /**
     * Specifies the elements of the entries that the Chart should have.
     * @param elements  Comma-separated values of Chart entries alternating between x and y values.
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING, defaultValue = "")
    @SimpleProperty(description="To be done (non-functional for now)",  category = PropertyCategory.BEHAVIOR)
    public void ElementsFromPairs(String elements) {
        // Base case:  nothing to add
        if (elements.equals("")) {
            return;
        }

        chartModel.setElements(elements);
        refreshChart();
    }


    /**
     * Adds elements to the Data component from a specified TinyDB component
     *
     * @param tinyDB  TinyDB component to import data from
     */
    @SimpleFunction(description = "Imports data from a TinyDB component. " +
      "Overrides the currently available data.")
    public void ImportFromTinyDB(TinyDB tinyDB) {
        chartModel.clearEntries();
        chartModel.importFromTinyDB(tinyDB);
        refreshChart();
    }

    /**
     * Adds elements to the Data component from a specified TinyDB component
     * without overriding the current data.
     *
     * @param tinyDB  TinyDB component to import data from
     */
    @SimpleFunction(description = "Imports data from a TinyDB component without overriding data.")
    public void AppendImportFromTinyDB(TinyDB tinyDB) {
        chartModel.importFromTinyDB(tinyDB);
        refreshChart();
    }

    /**
     * Adds elements to the Data component from specified x and y value
     * YailLists. Data is not overwritten.
     *
     * @param xValues  x value List to add
     * @param yValues  y value List to add
     */
    @SimpleFunction(description = "Imports data from x value and y value lists." +
      "Data is not overwritten.")
    public void ImportFromLists(YailList xValues, YailList yValues) {
        chartModel.importFromLists(xValues, yValues);
        refreshChart();
    }

    /**
     * Refreshes the Chart view object.
     */
    protected void refreshChart() {
        container.Refresh();
    }

    @Override
    public HandlesEventDispatching getDispatchDelegate() {
        return null;
    }
}