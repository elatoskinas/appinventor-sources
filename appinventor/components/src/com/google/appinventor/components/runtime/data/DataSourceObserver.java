package com.google.appinventor.components.runtime.data;

/**
 * Interface that represents Data Source observers (objects that can
 * observe Observable Data Sources).
 *
 * Contains the necessary signatures to respond to events sent
 * by Data Sources.
 */
public interface DataSourceObserver {
  /**
   * Event callback that gets invoked whenever an observed
   * ObservableDataSource invokes an event.
   *
   * @param event  Event invoked by an ObservableDataSource
   */
  void onDataSourceEvent(final DataEvent event);
}
