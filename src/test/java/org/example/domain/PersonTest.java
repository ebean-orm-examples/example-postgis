package org.example.domain;

import com.avaje.ebean.Ebean;
import org.postgis.Point;
import org.postgis.Polygon;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class PersonTest {

  @Test
  public void insert() throws SQLException {

    List<Person> list = Ebean.find(Person.class).findList();
    for (Person person : list) {
      System.out.println(person.getPoint());
    }

    List<Person> list1 = Ebean.find(Person.class)
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
    p.save();
  }
}