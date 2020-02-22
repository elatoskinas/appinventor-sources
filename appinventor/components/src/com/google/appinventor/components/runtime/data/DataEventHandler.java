package com.google.appinventor.components.runtime.data;

/**
 * Class that handles Data Event handling.
 * Provides boilerplate methods for concrete extensions of events.
 * By default, each event is simply ignored and to be extended by
 * overriding subclasses.
 */
public class DataEventHandler {
  /**
   * Create a new instance of a Data Event Handler.
   */
  public DataEventHandler() {

  }

  /**
   * Handle the specified generic event.
   * Default fallback option.
   * @param event  Event to handle
   */
  public void handleEvent(DataEvent event) {
    // No default functionality
  }

  public void handleEvent(DataSendValueEvent event) {
    // No default functionality
  }

  public void handleEvent(DataUpdateValueEvent event) {
    // No default functionality
  }
}
