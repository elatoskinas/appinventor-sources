package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;

@DesignerComponent(version = YaVersion.LINECHART_COMPONENT_VERSION,
        category = ComponentCategory.CHARTS,
        description = "Line Chart Description sample",
        iconName = "images/spinner.png")
@SimpleObject
public class LineChart extends ChartComponent {
    /**
     * Creates a new AndroidViewComponent.
     *
     * @param container container, component will be placed in
     */
    protected LineChart(ComponentContainer container) {
        super(container);
    }
}
