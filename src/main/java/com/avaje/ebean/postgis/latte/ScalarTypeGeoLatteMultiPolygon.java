package com.avaje.ebean.postgis.latte;

import org.geolatte.geom.MultiPolygon;

public class ScalarTypeGeoLatteMultiPolygon extends ScalarTypeGeoLatteBase<MultiPolygon> {


  @Override
  public Class<MultiPolygon> getType() {
    return MultiPolygon.class;
  }

//
//  @Override
//  public void bind(DataBind bind, MultiPolygon value) throws SQLException {
//
//    if (value == null) {
//      bind.setNull(Types.OTHER);
//    } else {
//      WkbEncoder encoder = Wkb.newEncoder( Wkb.Dialect.POSTGIS_EWKB_1 );
//      ByteBuffer buffer = encoder.encode(value, ByteOrder.NDR);
//      bind.setBytes(buffer.toByteArray());
//    }
//  }
//
//
//  @Override
//  public MultiPolygon read(DataReader reader) throws SQLException {
//
//    Object object = reader.getObject();
//    if (object == null) {
//      return null;
//    }
//    return (MultiPolygon)PgLatte.toGeometry(object);
//  }

}
