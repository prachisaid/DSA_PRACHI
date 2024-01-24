//package questions;
//
//import java.util.Scanner;
//
//public class SJF
//{
//    static void findWaitingTime(Process[] proc, int n)
//    {
//        int[] rt = new int[n];
//
//        for (int i = 0; i < n; i++)
//            rt[i] = proc[i].bt;
//
//        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
//        int shortest = 0, finish_time;
//        boolean check = false;
//
//        while (complete != n) {
//
//            for (int j = 0; j < n; j++)
//            {
//                if ((proc[j].at <= t) && (rt[j] < minm) && rt[j] > 0) {
//                    minm = rt[j];
//                    shortest = j;
//                    check = true;
//                }
//            }
//
//            if (!check) {
//                t++;
//                continue;
//            }
//
//            rt[shortest]--;
//            minm = rt[shortest];
//
//            if (minm == 0)
//                minm = Integer.MAX_VALUE;
//
//
//            if (rt[shortest] == 0) {
//
//                complete++;
//                check = false;
//                finish_time = t + 1;
//
//                proc[shortest].wt = finish_time - proc[shortest].bt - proc[shortest].at;
//
//                if (proc[shortest].wt < 0)
//                    proc[shortest].wt = 0;
//            }
//            // Increment time
//            t++;
//        }
//    }
//
//
//    static void findTurnAroundTime(Process[] proc, int n)
//    {
//        for (int i = 0; i < n; i++){
//            proc[i].tat = proc[i].bt + proc[i].wt;
//            proc[i].ct = proc[i].tat + proc[i].at;
//        }
//    }
//
//
//    static void findavgTime(Process proc[], int n)
//    {
//        int total_wt = 0, total_tat = 0;
//
//        findWaitingTime(proc, n);
//        findTurnAroundTime(proc, n);
//
//        System.out.println("Processes " + " Burst time " + " Waiting time " + " Turn around time");
//
//        for (int i = 0; i < n; i++) {
//            total_wt = total_wt + proc[i].wt;
//            total_tat = total_tat + proc[i].tat;
//            System.out.println(" " + proc[i].id + "\t\t" + proc[i].bt + "\t\t " + proc[i].wt + "\t\t" + proc[i].tat);
//        }
//
//        System.out.println("Average waiting time = " + (float)total_wt / (float)n);
//        System.out.println("Average turn around time = " + (float)total_tat / (float)n);
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println("Enter total number of processes ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        Process[] proc = new Process[n];
//
//        for(int i = 0; i < n; i++) {
//            System.out.print("Enter process id ");
//            int id = sc.nextInt();
//            System.out.print("Enter burst time ");
//            int bt = sc.nextInt();
//            System.out.print("Enter arrival time ");
//            int at = sc.nextInt();
//
//            proc[i] = new Process(id, bt, at);
//        }
//
//        findavgTime(proc, proc.length);
//    }
//}