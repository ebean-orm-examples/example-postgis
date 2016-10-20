package org.example.domain;

import com.avaje.ebean.Ebean;
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

    List<PersonLatte> list = Ebean.find(PersonLatte.class).findList();
    for (PersonLatte personP : list) {
      System.out.println(personP.getPoint());
    }


    Point point = (Point) Wkt.fromWkt("SRID=4674;POINT (12 23)");
    Polygon poly = (Polygon) Wkt.fromWkt("SRID=4674;POLYGON((2 2, 2 -2, -2 -2, -2 2, 2 2))");
    MultiPolygon mp = (MultiPolygon) Wkt.fromWkt("SRID=4674;MULTIPOLYGON(((2 2, 2 -2, -2 -2, -2 2, 2 2)),((1 1, 3 1, 3 3, 1 3, 1 1)))");

    PersonLatte p = new PersonLatte();
    p.setName("geolatte at "+System.currentTimeMillis());
    p.setMpoly(mp);
    p.setPoint(point);
    p.setPoly(poly);

    Ebean.save(p);
  }
}