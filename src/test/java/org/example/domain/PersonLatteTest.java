package org.example.domain;


import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.postgis.latte.ScalarTypeGeoLattePoint;
import com.avaje.ebean.postgis.latte.ScalarTypeGeoLattePolygon;
import com.avaje.ebean.postgis.ScalarTypePGpoint;
import com.avaje.ebean.postgis.latte.ScalarTypeGeoLatteMultiPolygon;
import com.avaje.ebean.postgis.ScalarTypePgisMultiPolygon;
import com.avaje.ebean.postgis.ScalarTypePgisPoint;
import org.geolatte.geom.MultiPolygon;
import org.geolatte.geom.Point;
import org.geolatte.geom.Polygon;
import org.geolatte.geom.codec.Wkt;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;



public class PersonLatteTest {

  @Test
  public void insert() throws SQLException {


    ServerConfig serverConfig = new ServerConfig();
    serverConfig.setName("db");
    serverConfig.loadFromProperties();
    serverConfig.addClass(ScalarTypePgisPoint.class);
    serverConfig.addClass(ScalarTypePgisMultiPolygon.class);

    serverConfig.addClass(ScalarTypeGeoLatteMultiPolygon.class);
    serverConfig.addClass(ScalarTypeGeoLattePolygon.class);
    serverConfig.addClass(ScalarTypeGeoLattePoint.class);
    serverConfig.addClass(ScalarTypePGpoint.class);

    serverConfig.addClass(Person.class);
    serverConfig.addClass(PersonLatte.class);


    EbeanServer ebeanServer = EbeanServerFactory.create(serverConfig);

    List<PersonLatte> list = ebeanServer.find(PersonLatte.class).findList();
    for (PersonLatte personP : list) {
      System.out.println(personP.getPoint());
    }


    Point pt = (Point) Wkt.fromWkt("SRID=4674;POINT (12 23)");
    Polygon poly = (Polygon) Wkt.fromWkt("SRID=4674;POLYGON((2 2, 2 -2, -2 -2, -2 2, 2 2))");
    MultiPolygon mp = (MultiPolygon) Wkt.fromWkt("SRID=4674;MULTIPOLYGON(((2 2, 2 -2, -2 -2, -2 2, 2 2)),((1 1, 3 1, 3 3, 1 3, 1 1)))");

    PersonLatte p = new PersonLatte();
    p.setName("me at "+System.currentTimeMillis());
    p.setMpoly(mp);
    p.setPoint(pt);
    p.setPoly(poly);

    ebeanServer.save(p);
  }
}