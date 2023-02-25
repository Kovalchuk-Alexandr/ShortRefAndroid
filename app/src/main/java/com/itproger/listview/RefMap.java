package com.itproger.listview;

import java.util.HashMap;

public class RefMap extends HashMap<String, String> {
    static final String SHORTREF = "shortref";
    static final String FULLREF = "fullref";

    // Конструктор с параметрами
    public RefMap(String shortref, String fullref) {
        super();
        super.put(SHORTREF, shortref);
        super.put(FULLREF, fullref);
    }

//    public boolean GetRef(String shortref) {
//        if(super.get(shortref)) return true;
//    }
}
