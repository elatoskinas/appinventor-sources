// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2014 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.simple.components;

import static com.google.appinventor.client.Ode.MESSAGES;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.appinventor.client.output.OdeLog;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * Mock ListView component.
 *
 */
public final class MockRecyclerView extends MockImageBase {

    /**
     * Component type name.
     */
    public static final String TYPE = "RecyclerView";

    /**
     * Creates a new MockImage component.
     *
     * @param editor  editor of source file the component belongs to
     */
    public MockRecyclerView(SimpleEditor editor) {
        super(editor, TYPE, images.image());
    }
}
