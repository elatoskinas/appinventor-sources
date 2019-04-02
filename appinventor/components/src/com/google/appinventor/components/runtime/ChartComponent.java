package com.google.appinventor.components.runtime;

import android.view.View;
import android.widget.TextView;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.TextViewUtil;

@SimpleObject
public class ChartComponent extends AndroidViewComponent {
    private final android.widget.TextView view;

    private boolean scaleXEnabled;

    /**
     * Creates a new AndroidViewComponent.
     *
     * @param container container, component will be placed in
     */
    protected ChartComponent(ComponentContainer container) {
        super(container);

        view = new TextView(container.$context());

        // Adds the component to its designated container
        container.$add(this);

        ScaleXEnabled(true);
    }


    @Override
    public View getView() {
        return view;
    }

    /**
     * Returns the  scaleXEnabled property of the chart, which
     * indicates whether the chart can be scaled horizontally by the User.
     *
     * @return  {@code true} indicates enabled, {@code false} disabled
     */
    @SimpleProperty(
            category = PropertyCategory.BEHAVIOR,
            description = "Specifies whether the chart can be scaled horizontally")
    public boolean ScaleXEnabled() {
        return scaleXEnabled;
    }

    /**
     * Specifies whether the chart can be scaled horizontally.
     *
     * @param scaleXEnabled  {@code true} for enabled, {@code false} disabled
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
            defaultValue = "True")
    @SimpleProperty
    public void ScaleXEnabled(boolean scaleXEnabled) {
        this.scaleXEnabled = scaleXEnabled;
        // Code to change the Chart would go here
    }

    /**
     * Indicates that the chart has been single tapped.
     */
    @SimpleEvent(description = "Indicates that the chart has been single tapped")
    public void SingleTap() {
        EventDispatcher.dispatchEvent(this, "SingleTap");
    }

    /**.
     * Adds a new entry to the dataset
     * @param x - Entry x value
     * @param y - Entry y value
     */
    @SimpleFunction
    public void AddEntry(int x, int y) {
        // Function logic here to add the entry
    }

}


