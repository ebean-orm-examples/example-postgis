package com.avaje.ebean.postgis;

import org.postgis.Polygon;

public class ScalarTypePgisPolygon extends ScalarTypePgisBase<Polygon> {

  @Override
  public Class<Polygon> getType() {
    return Polygon.class;
  }

}
