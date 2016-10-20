package com.avaje.ebean.postgis.latte;

import org.geolatte.geom.Polygon;

public class ScalarTypeGeoLattePolygon extends ScalarTypeGeoLatteBase<Polygon> {

  @Override
  public Class<Polygon> getType() {
    return Polygon.class;
  }

}
