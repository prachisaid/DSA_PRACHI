package questions;

import java.util.*;

class Process implements Comparable <Process>{
    int id, at, bt, rt, ct, tat, wt;
    boolean comp;

    public Process(int id, int a, int b) {
        this.id = id;
        this.at = a;
        this.bt = b;
        this.rt = b;
        this.comp = false;
    }

    @Override
    public int compareTo(Process o1) {
        return this.at - o1.at;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        System.out.println("Enter number of process ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Process[] proc = new Process[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Enter process id ");
            int id = sc.nextInt();
            System.out.print("Enter arrival time ");
            int at = sc.nextInt();
            System.out.print("Enter burst time ");
            int bt = sc.nextInt();

            proc[i] = new Process(id, at, bt);
        }

        Arrays.sort(proc);

        int curTime = 0;
        int remProc = 0;

        int tq = 4;

        while(remProc < n) {
            for(int i = 0; i < n; i++) {
                if(proc[i].rt <= tq && !proc[i].comp) {
                    proc[i].comp = true;
                    curTime += proc[i].rt;
                    proc[i].rt = 0;

//                    System.out.println("Process : "+proc[i].id+" completed in time: " + curTime);
                    proc[i].ct = curTime;
                    remProc++;
                }
                else if(proc[i].rt > tq && !proc[i].comp) {
                    proc[i].rt -= tq;
                    curTime += tq;
                }
            }
        }

        float totalWt = 0f, totalTat = 0f;
        
        for(int i = 0; i < n; i++) {
            proc[i].tat = proc[i].ct - proc[i].at;
            proc[i].wt = proc[i].tat - proc[i].bt;
            
            totalWt += proc[i].wt;
            totalTat += proc[i].tat;
        }

        System.out.println("Process id \t Arrival Time \t Burst Time \t Completion Time \t Turn Around Time \t Waiting time");

        for (int i = 0; i < n; i++) {
            System.out.println(proc[i].id + "\t\t\t\t" + proc[i].at + "\t\t\t\t" + proc[i].bt + "\t\t\t\t"
                    + proc[i].ct
                    + "\t\t\t\t\t" + proc[i].tat + "\t\t\t\t\t" + proc[i].wt);
        }

        System.out.println("Average waiting time " + (totalWt / n));
        System.out.println("Average turn around time " + (totalTat / n));
    }
}