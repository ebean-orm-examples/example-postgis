package com.avaje.ebean.postgis;

import org.postgis.Point;

public class ScalarTypePgisPoint extends ScalarTypePgisBase<Point> {


  @Override
  public Class<Point> getType() {
    return Point.class;
  }


//  @Override
//  public void bind(DataBind bind, Point value) throws SQLException {
//
//    if (value == null) {
//      bind.setNull(Types.OTHER);
//    } else {
//      //value.outerWKT();
//      //String value1 = value.getValue();
//      PGgeometryLW pt = new PGgeometryLW(value);
//      bind.setObject(pt);
//    }
//  }
//
//  @Override
//  public Point read(DataReader reader) throws SQLException {
//
//    Object object = reader.getObject();
//    if (object == null) {
//      return null;
//    }
//    PGgeometryLW gro = (PGgeometryLW)object;
//    Geometry pts = gro.getGeometry();
//    return (Point)pts;
//  }

}
