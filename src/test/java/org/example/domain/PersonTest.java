package org.example.domain;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.postgis.latte.ScalarTypeGeoLatteMultiPolygon;
import com.avaje.ebean.postgis.ScalarTypePGpoint;
import com.avaje.ebean.postgis.ScalarTypePgisMultiPolygon;
import com.avaje.ebean.postgis.ScalarTypePgisPoint;
import com.avaje.ebean.postgis.ScalarTypePgisPolygon;
import org.postgis.Point;
import org.postgis.Polygon;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class PersonTest {

  @Test
  public void insert() throws SQLException {


    ServerConfig serverConfig = new ServerConfig();
    serverConfig.setName("db");
    serverConfig.setDefaultServer(true);
    serverConfig.loadFromProperties();
    serverConfig.addClass(ScalarTypePgisPoint.class);
    serverConfig.addClass(ScalarTypePgisPolygon.class);
    serverConfig.addClass(ScalarTypePgisMultiPolygon.class);

    serverConfig.addClass(ScalarTypeGeoLatteMultiPolygon.class);
    serverConfig.addClass(ScalarTypePGpoint.class);

    serverConfig.addClass(Person.class);
    serverConfig.addClass(PersonLatte.class);


    EbeanServer ebeanServer = EbeanServerFactory.create(serverConfig);

    List<Person> list = ebeanServer.find(Person.class).findList();
    for (Person person : list) {
      System.out.println(person.getPoint());
    }

    List<Person> list1 = ebeanServer.find(Person.class)
        .where()
        .raw("st_within(st_pointfromwkb(st_point(?, ?), 4674), poly)", 1.9, 1.9)
        .findList();

    System.out.println(list1);


    Point point = new Point("SRID=4674;POINT(2.8 1.7)");
    Polygon poly =  new Polygon("SRID=4674;POLYGON((2 2, 2 -2, -2 -2, -2 2, 2 2))");

    Person p = new Person();
    p.setName("me at "+System.currentTimeMillis());
    p.setPoint(point);
    p.setPoly(poly);
    ebeanServer.save(p);
  }
}