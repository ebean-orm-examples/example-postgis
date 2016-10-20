package com.avaje.ebean.postgis;

import com.avaje.ebeaninternal.server.type.CtCompoundTypeScalarList;
import com.avaje.ebeaninternal.server.type.DataBind;
import com.avaje.ebeaninternal.server.type.DataReader;
import com.avaje.ebeaninternal.server.type.ScalarType;
import com.avaje.ebeanservice.docstore.api.mapping.DocPropertyType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import org.postgresql.geometric.PGpoint;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.SQLException;

//import org.geolatte.geom.ByteBuffer;
//import org.geolatte.geom.ByteOrder;
//import org.geolatte.geom.Geometry;
//import org.geolatte.geom.Point;
//import org.geolatte.geom.codec.Wkb;
//import org.geolatte.geom.codec.WkbDecoder;
//import org.geolatte.geom.codec.WkbEncoder;
//import org.geolatte.geom.codec.Wkt;
//import org.geolatte.geom.codec.WktDecoder;

public class ScalarTypePGpoint implements ScalarType<PGpoint> {


  @Override
  public Class<PGpoint> getType() {
    return PGpoint.class;
  }


  @Override
  public void bind(DataBind bind, PGpoint value) throws SQLException {

//    final WkbEncoder encoder = Wkb.newEncoder( Wkb.Dialect.POSTGIS_EWKB_1 );
//    //final Geometry geometry = value;//getJavaDescriptor().unwrap( value, Geometry.class, options );
//    final byte[] bytes = encoder.encode( value, ByteOrder.NDR ).toByteArray();
//
//    //PGObjectFactory factory = new PGObjectFactory();
//    //factory.getObjectInstance()

//    PGpoint pt = new PGpoint(5d, 10d);
//
//    System.out.println(pt.toString());
//    PGobject pgo = new PGobject();
//    pgo.setType("point");
//    pgo.setValue(pt.toString());
////    pgo.setType("point");
////    pgo.setValue("POINT (5 10)");//SRID=4326;


    //bind.getPstmt();
    bind.setObject(value);//, Types.OTHER);

    //bind.setBytes(bytes);
  }


  @Override
  public PGpoint read(DataReader reader) throws SQLException {

    Object object = reader.getObject();
    PGpoint geometry = (PGpoint)object;
   // Geometry geometry = toGeometry(object);
    return (PGpoint)geometry;
  }

//  static Geometry toGeometry(Object object) {
//    if ( object == null ) {
//      return null;
//    }
//    ByteBuffer buffer = null;
//    if ( object instanceof PGobject) {
//      String pgValue = ((PGobject) object ).getValue();
//      if (pgValue.charAt( 0 ) == 'S') { // /we have a Wkt value
//        final WktDecoder decoder = Wkt.newDecoder( Wkt.Dialect.POSTGIS_EWKT_1 );
//        return decoder.decode(pgValue);
//      }
//      else {
//        buffer = ByteBuffer.from( pgValue );
//        final WkbDecoder decoder = Wkb.newDecoder( Wkb.Dialect.POSTGIS_EWKB_1 );
//        return decoder.decode( buffer );
//      }
//    }
//    throw new IllegalStateException( "Received object of type " + object.getClass().getCanonicalName() );
//  }

  @Override
  public PGpoint readData(DataInput dataInput) throws IOException {
    return null;
  }

  @Override
  public void writeData(DataOutput dataOutput, PGpoint v) throws IOException {

  }

  @Override
  public boolean isBinaryType() {
    return false;
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public boolean isDirty(Object value) {
    return false;
  }

  @Override
  public int getLength() {
    return 0;
  }

  @Override
  public boolean isJdbcNative() {
    return false;
  }

  @Override
  public int getJdbcType() {
    return 0;
  }


  @Override
  public void loadIgnore(DataReader reader) {

  }

  @Override
  public void accumulateScalarTypes(String propName, CtCompoundTypeScalarList list) {

  }

  @Override
  public Object toJdbcType(Object value) {
    return null;
  }

  @Override
  public PGpoint toBeanType(Object value) {
    return null;
  }

  @Override
  public String formatValue(PGpoint value) {
    return null;
  }

  @Override
  public String format(Object value) {
    return null;
  }

  @Override
  public PGpoint parse(String value) {
    return null;
  }

  @Override
  public DocPropertyType getDocType() {
    return null;
  }

  @Override
  public boolean isDateTimeCapable() {
    return false;
  }

  @Override
  public long asVersion(PGpoint value) {
    return 0;
  }

  @Override
  public PGpoint convertFromMillis(long dateTime) {
    return null;
  }



  @Override
  public PGpoint jsonRead(JsonParser parser) throws IOException {
    return null;
  }

  @Override
  public void jsonWrite(JsonGenerator writer, PGpoint value) throws IOException {

  }
}
