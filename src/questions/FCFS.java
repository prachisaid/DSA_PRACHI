//package questions;
//
//import java.util.*;
//
//class Process implements Comparable <Process>{
//    int id, at, bt, ct, tat, wt;
//
//    public Process(int a, int b, int c) {
//        this.id = a;
//        this.at = b;
//        this.bt = c;
//    }
//    @Override
//    public int compareTo(Process o2) {
//        return this.at - o2.at;
//    }
//}
//public class FCFS {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of processes ");
//        int n = sc.nextInt();
//        Process[] processes = new Process[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter pid ");
//            int id = sc.nextInt();
//            System.out.print("Enter arrival time ");
//            int at = sc.nextInt();
//            System.out.print("Enter burst time ");
//            int bt = sc.nextInt();
//
//            processes[i] = new Process(id, at, bt);
//        }
//
//        Arrays.sort(processes);
//
//        float avgwt = 0;
//        float avgtat = 0;
//
//        for (int i = 0; i < n; i++) {
//            if(i == 0) {
//                processes[i].ct = processes[i].bt;
//            }
//            else{
//                processes[i].ct = processes[i].bt + processes[i-1].ct;
//            }
//
//            processes[i].tat = processes[i].ct - processes[i].at;
//            processes[i].wt = processes[i].tat - processes[i].bt;
//
//            avgtat += processes[i].tat;
//            avgwt += processes[i].wt;
//        }
//
//        System.out.println("Process id \t Arrival Time \t Burst Time \t Completion Time \t Turn Around Time \t Waiting time");
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(processes[i].id + "\t\t\t\t" + processes[i].at + "\t\t\t\t" + processes[i].bt + "\t\t\t\t"
//                    + processes[i].ct
//                    + "\t\t\t\t\t" + processes[i].tat + "\t\t\t\t\t" + processes[i].wt);
//        }
//
//        System.out.println("Average waiting time " + (avgwt / n));
//        System.out.println("Average turn around time " + (avgtat / n));
//    }
//}