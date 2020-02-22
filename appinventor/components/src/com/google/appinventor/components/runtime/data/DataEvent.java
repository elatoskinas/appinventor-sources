package com.google.appinventor.components.runtime.data;

/**
 * Class that represents an event originating from
 * Data Sources.
 */
public abstract class DataEvent {
  private DataSource origin;

  /**
   * Create new Data Event instance.
   */
  public DataEvent(DataSource origin) {
    this.origin = origin;
  }

  public DataSource getOrigin() {
    return this.origin;
  }
}
