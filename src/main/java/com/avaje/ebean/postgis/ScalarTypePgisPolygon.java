package com.avaje.ebean.postgis;

import org.postgis.Polygon;

public class ScalarTypePgisPolygon extends ScalarTypePgisBase<Polygon> {


  @Override
  public Class<Polygon> getType() {
    return Polygon.class;
  }

//
//  @Override
//  public void bind(DataBind bind, Polygon value) throws SQLException {
//
//    PGgeometryLW pt = new PGgeometryLW(value);
//    bind.setObject(pt);
//  }
//
//
//  @Override
//  public Polygon read(DataReader reader) throws SQLException {
//
//    Object object = reader.getObject();
//    if (object == null) {
//      return null;
//    }
//    PGgeometryLW gro = (PGgeometryLW)object;
//    Geometry pts = gro.getGeometry();
//    return (Polygon)pts;
//  }

}
