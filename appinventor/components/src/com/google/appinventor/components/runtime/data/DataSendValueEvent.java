package com.google.appinventor.components.runtime.data;

/**
 * Data Event corresponding to an event when a Data Source
 * sends a new value with a key attached to it.
 */
public class DataSendValueEvent extends DataEvent {
  private String key;
  private Object value;

  public DataSendValueEvent(DataSource origin, String key, Object value) {
    super(origin);

    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }
}
