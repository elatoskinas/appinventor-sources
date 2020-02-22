// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2019-2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime.data;

import com.google.appinventor.components.runtime.ChartDataBase;

/**
 * Interface for observable Data Source components.
 * Contains the necessary methods to link, unlink and
 * notify observers
 *
 * @param <K>  key (data identifier)
 * @param <V>  value (returned data type)
 */
public interface ObservableDataSource<K,V> extends DataSource<K,V> {
  /**
   * Adds a new observer to the Data Source
   * @param observer  observer to add
   */
  void addDataObserver(DataSourceObserver observer);

  /**
   * Removes the specified observer from the observers list,
   * if it exists.
   * @param observer  observer to remove
   */
  void removeDataObserver(DataSourceObserver observer);

  /**
   * Notifies the observers with the specified sent.
   * @param event  Data Event to send to observers
   */
  void notifyDataObservers(DataEvent event);
}
