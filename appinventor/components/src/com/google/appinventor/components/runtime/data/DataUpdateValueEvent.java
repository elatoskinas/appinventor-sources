package com.google.appinventor.components.runtime.data;

/**
 * Data Event corresponding to the event when a Data Source updates it's value.
 * This means that the old data with the key identified by this event is obsolete.
 */
public class DataUpdateValueEvent extends DataSendValueEvent {
  public DataUpdateValueEvent(DataSource origin, String key, Object value) {
    super(origin, key, value);
  }
}
