package pers.gglt.note.java.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection_ {
    ArrayList list = new ArrayList();


    /**
     * 遍历
     */
    void for_() {
        for (int i = 0; i < list.size(); i++) ;
    }

    void enhancedFor() {
        for (Object o : list) ;
    }

    void iterator() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
        }
    }
}
