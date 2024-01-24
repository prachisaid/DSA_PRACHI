package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesignHashset {
    LinkedList<Integer> lst;
    public DesignHashset() {
        lst = new LinkedList<>();
    }

    public void add(int key) {
        if(!lst.contains(key)){
            lst.add(key);
        }
    }

    public void remove(int key) {
        if(lst.contains(key)){
            lst.remove(lst.indexOf(key));
        }
    }

    public boolean contains(int key) {
        if(lst.contains(key)){
            return true;
        }

        return false;
    }
}
