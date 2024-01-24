package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    public static void main(String[] args) {

    }

    int tour(int petrol[], int distance[]) {
        int deficit = 0;
        int balance = 0;
        int start = 0;
        int n = petrol.length;

        for(int i = 0; i < n; i++){
            balance += petrol[i] - distance[i] ;
            if(balance < 0){
                deficit = balance;
                start = i + 1;
                balance = 0;
            }
        }

        if(deficit + balance >= 0){
            return start;
        }
        else{
            return -1;
        }
    }
}
