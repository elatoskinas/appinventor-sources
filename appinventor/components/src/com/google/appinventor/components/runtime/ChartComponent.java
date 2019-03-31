package com.google.appinventor.components.runtime;

import android.view.View;
import android.widget.TextView;
import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public class ChartComponent extends AndroidViewComponent {
    private final android.widget.TextView view;

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
    }


    @Override
    public View getView() {
        return view;
    }
}


