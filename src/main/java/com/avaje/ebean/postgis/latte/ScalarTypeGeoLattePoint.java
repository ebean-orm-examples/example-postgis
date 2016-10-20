package com.avaje.ebean.postgis.latte;

import org.geolatte.geom.Point;

public class ScalarTypeGeoLattePoint extends ScalarTypeGeoLatteBase<Point> {

  @Override
  public Class<Point> getType() {
    return Point.class;
  }

}
