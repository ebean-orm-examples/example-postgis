package com.avaje.ebean.postgis;

import org.postgis.Point;

public class ScalarTypePgisPoint extends ScalarTypePgisBase<Point> {

  @Override
  public Class<Point> getType() {
    return Point.class;
  }

}
