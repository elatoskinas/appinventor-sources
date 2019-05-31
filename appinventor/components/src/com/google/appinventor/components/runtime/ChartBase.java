package com.google.appinventor.components.runtime;

import com.github.mikephil.charting.data.ChartData;
import com.google.appinventor.components.annotations.*;
import com.github.mikephil.charting.charts.Chart;
import com.google.appinventor.components.common.PropertyTypeConstants;

@SimpleObject
@UsesLibraries(libraries = "mpandroidchart.jar")
public abstract class ChartBase<T extends Chart, D extends ChartData> extends AndroidViewComponent {

    protected T view;
    protected D data;

    private String description;
    private int backgroundColor;


    /**
     * Creates a new ChartBase component.
     *
     * @param container container, component will be placed in
     */
    protected ChartBase(ComponentContainer container) {
        super(container);
    }

    /**
     * Initializes the Base Chart object instance.
     */
    protected void initChart() {
        // Adds the view to the designated container
        container.$add(this);

        // Set default values
        BackgroundColor(Component.COLOR_DEFAULT);
        Description("");

        view.setEnabled(true);
    }

    /**
     * Returns the description label text of the Chart.
     *
     * @return  description label
     */
    @SimpleProperty(
            category = PropertyCategory.APPEARANCE)
    public String Description() {
        return description;
    }

    /**
     * Specifies the text displayed by the description label.
     *
     * @param text  description
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
        defaultValue = "")
    @SimpleProperty
    public void Description(String text) {
        this.description = text;
        view.getDescription().setText(description);
    }

    /**
     * Returns the chart's background color as an alpha-red-green-blue
     * integer.
     *
     * @return  background RGB color with alpha
     */
    @SimpleProperty(
            category = PropertyCategory.APPEARANCE)
    public int BackgroundColor() {
        return backgroundColor;
    }

    /**
     * Specifies the chart's background color as an alpha-red-green-blue
     * integer.
     *
     * @param argb  background RGB color with alpha
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
            defaultValue = Component.DEFAULT_VALUE_COLOR_NONE)
    @SimpleProperty
    public void BackgroundColor(int argb) {
        backgroundColor = argb;

        view.setBackgroundColor(argb);
    }

    /**
     * Refreshes the Chart to react to Data Set changes.
     */
    public void Refresh() {
        view.notifyDataSetChanged();
        view.invalidate();
    }
}
