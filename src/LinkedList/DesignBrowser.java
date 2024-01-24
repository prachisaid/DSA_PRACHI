package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesignBrowser {
    ArrayList<String> lst;
    int current = 0;

    public DesignBrowser(String homepage) {
        lst = new ArrayList<>();
        lst.add(homepage);
        current += 1;
    }

    public void visit(String url) {
        while(lst.size()-1 > current){
            lst.remove(lst.size()-1);
        }

        lst.add(url);
        current += 1;
    }

    public String back(int steps) {
        if(steps > current){
            current = 0;
        }

        else{
            current -= steps;
        }

        return lst.get(current);
    }

    public String forward(int steps) {
        if(steps + current > lst.size()){
            current = lst.size()-1;
        }
        else{
            current += steps;
        }

        return lst.get(current);
    }
}
