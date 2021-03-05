package com.nathan.learn.collection;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class TreeMapLearn {

  /** Comparator for paths which considers the /. */
  public static final Comparator<String> PATH_COMPARATOR =
      new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          String s1 = o1.replace('/', ' ');
          String s2 = o2.replace('/', ' ');
          return s1.compareTo(s2);
        }
      };


  public static void main(String[] args) {
    // creating tree map
    TreeMap<String, String> treemap = new TreeMap<String, String>();

    // populating tree map
    treemap.put("/lfrz", "1");
    treemap.put("/lfrz/ddedw", "2");
//    treemap.put("/lfrz/ddedw/app", "3");
    treemap.put("/lfrz/ddedw/app/t1", "4");
    treemap.put("/lfrz/ddedw/app2/t2", "5");
    treemap.put("/lfrz/ddedw/app2", "6");

    System.out.println("Value is: " + treemap.floorEntry("/lfrz/ddedw/app"));
    System.out.println("Value is: " + treemap.lowerEntry("/lfrz/ddedw/app"));
    System.out.println("Value is: " + treemap.floorEntry("/lfrz/ddedw/app3/t2"));
    System.out.println("Value is: " + treemap.lowerEntry("/lfrz/ddedw/app2/t2"));
  }
}
