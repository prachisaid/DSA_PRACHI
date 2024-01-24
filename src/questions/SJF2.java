package questions;

import java.util.Scanner;

public class SJF2 {
    public static void main(String[] args) {
        System.out.println("Enter total number of processes ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Process[] proc = new Process[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Enter process id ");
            int id = sc.nextInt();
            System.out.print("Enter burst time ");
            int bt = sc.nextInt();
            System.out.print("Enter arrival time ");
            int at = sc.nextInt();

            proc[i] = new Process(id, at, bt);
        }

        sjf(proc, proc.length);
    }

    public static void sjf(Process[] proc, int n) {
        int totalWt = 0, totalTat = 0;

        findWaitingtime(proc, n);
        findTurnAroundTime(proc, n);

        System.out.println("Process id \t Arrival Time \t Burst Time \t Completion time \t Turn Around Time \t Waiting Time");

        for(int i = 0; i < n; i++) {
            totalWt += proc[i].wt;
            totalTat += proc[i].tat;

            System.out.println(proc[i].id + "\t\t\t\t" + proc[i].at + "\t\t\t\t" + proc[i].bt + "\t\t\t\t" +
                    proc[i].ct + "\t\t\t\t\t" + proc[i].tat + "\t\t\t\t\t" + proc[i].wt);
        }

        System.out.println("Average turn around time " + (totalTat / n));
        System.out.println("Average waiting time " + (totalWt / n));
    }

    private static void findWaitingtime(Process[] proc, int n){
        int[] rt = new int[n];

        for(int i = 0; i < n; i++) {
            rt[i] = proc[i].bt;
        }

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finishTime;
        boolean check = false;

        while(complete != n) {

            for(int i = 0; i < n; i++) {
                if((proc[i].at <= t) && (rt[i] < minm) && rt[i] > 0) {
                    minm = rt[i];
                    shortest = i;
                    check = true;
                }
            }

            if(!check) {
                t++;
                continue;
            }

            rt[shortest]--;
            minm = rt[shortest];

            if(minm == 0) {
                minm = Integer.MAX_VALUE;
            }

            if(rt[shortest] == 0) {
                complete++;
                check = false;
                finishTime = t + 1;

                proc[shortest].wt = finishTime - proc[shortest].bt - proc[shortest].at;

                if(proc[shortest].wt < 0) {
                    proc[shortest].wt = 0;
                }
            }

            t++;
        }
    }

    private static void findTurnAroundTime(Process[] proc, int n) {
        for(int i = 0; i < n; i++) {
            proc[i].tat = proc[i].bt + proc[i].wt;
            proc[i].ct = proc[i].at + proc[i].tat;
        }
    }
}
