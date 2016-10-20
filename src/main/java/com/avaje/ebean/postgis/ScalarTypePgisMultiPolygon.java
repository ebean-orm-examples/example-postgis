package com.avaje.ebean.postgis;

import org.postgis.MultiPolygon;

public class ScalarTypePgisMultiPolygon extends ScalarTypePgisBase<MultiPolygon> {

  @Override
  public Class<MultiPolygon> getType() {
    return MultiPolygon.class;
  }

}
