package com.example.preferancesandrecycleview;

import java.util.ArrayList;

public class ArrayListConverterToLong {

   public static ArrayList<Long> stringsToLongs(ArrayList<String>listString)  {
        ArrayList<Long> list = new ArrayList<>();
        for (String s : listString) {
            list.add( Long.valueOf(s));
        }
        return list;
    }

  public static   ArrayList<String> longToString(ArrayList<Long>listLong)  {
        ArrayList<String> list = new ArrayList<>();
        for (Long l : listLong) {
            list.add( String.valueOf(l));
        }
        return list;
    }

}
