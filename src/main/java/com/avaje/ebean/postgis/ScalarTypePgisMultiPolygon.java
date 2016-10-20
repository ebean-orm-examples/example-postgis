package com.avaje.ebean.postgis;

import com.avaje.ebeaninternal.server.type.DataBind;
import com.avaje.ebeaninternal.server.type.DataReader;
import org.postgis.Geometry;
import org.postgis.MultiPolygon;
import org.postgis.PGgeometryLW;

import java.sql.SQLException;
import java.sql.Types;

public class ScalarTypePgisMultiPolygon extends ScalarTypePgisBase<MultiPolygon> {


  @Override
  public Class<MultiPolygon> getType() {
    return MultiPolygon.class;
  }


  @Override
  public void bind(DataBind bind, MultiPolygon value) throws SQLException {

    if (value == null) {
      bind.setNull(Types.NULL);
    } else {
      PGgeometryLW pt = new PGgeometryLW(value);
      bind.setObject(pt);
    }
  }


  @Override
  public MultiPolygon read(DataReader reader) throws SQLException {

    Object object = reader.getObject();
    if (object == null) {
      return null;
    }
    PGgeometryLW gro = (PGgeometryLW)object;
    Geometry pts = gro.getGeometry();
    return (MultiPolygon)pts;
  }

}
