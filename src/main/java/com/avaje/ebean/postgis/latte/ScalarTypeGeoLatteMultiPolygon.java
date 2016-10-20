package com.avaje.ebean.postgis.latte;

import org.geolatte.geom.MultiPolygon;

public class ScalarTypeGeoLatteMultiPolygon extends ScalarTypeGeoLatteBase<MultiPolygon> {

  @Override
  public Class<MultiPolygon> getType() {
    return MultiPolygon.class;
  }

}
