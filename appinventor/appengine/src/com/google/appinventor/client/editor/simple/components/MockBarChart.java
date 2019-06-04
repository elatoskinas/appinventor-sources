package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.gwt.resources.client.ImageResource;
import org.pepstock.charba.client.BarChart;
import org.pepstock.charba.client.resources.EmbeddedResources;
import org.pepstock.charba.client.resources.ResourcesType;

public final class MockBarChart extends MockVisibleComponent {
    private static final String PROPERTY_DESCRIPTION = "Description";

    public static final String TYPE = "BarChart";

    private BarChart barChartWidget;

    static {
        ResourcesType.setClientBundle(EmbeddedResources.INSTANCE);
    }

    /**
     * Creates a new instance of a Mock Bar Chart component.
     *
     * @param editor editor of source file the component belongs to
     */
    public MockBarChart(SimpleEditor editor) {
        super(editor, TYPE, images.image());

        // Initialize Bar Chart mock Widget
        barChartWidget = new BarChart();

        // Chart widget setup
        barChartWidget.getOptions().setMaintainAspectRatio(false);
        barChartWidget.getOptions().getTitle().setDisplay(true);
        barChartWidget.setStylePrimaryName("ode-SimpleMockComponent");
        initComponent(barChartWidget);
    }
}