package questions;

import java.util.Arrays;
import java.util.Scanner;

class Job implements Comparable <Job>{
    int id, at, bt, ct, tat, wt, pr;

    public Job(int a, int b, int c, int d) {
        this.id = a;
        this.at = b;
        this.bt = c;
        this.pr = d;
    }
    @Override
    public int compareTo(Job o2) {
        if(this.at == o2.at) {
            return this.pr - o2.pr;
        }
        else{
            return this.at - o2.at;
        }
    }
}

public class PrioritySch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter pid ");
            int id = sc.nextInt();
            System.out.print("Enter arrival time ");
            int at = sc.nextInt();
            System.out.print("Enter burst time ");
            int bt = sc.nextInt();
            System.out.print("Enter priority ");
            int pr = sc.nextInt();

            jobs[i] = new Job(id, at, bt, pr);
        }

        Arrays.sort(jobs);

        float avgwt = 0;
        float avgtat = 0;

        for (int i = 0; i < n; i++) {
            if(i == 0) {
                jobs[i].ct = jobs[i].bt;
            }
            else{
                jobs[i].ct = jobs[i].bt + jobs[i-1].ct;
            }

            jobs[i].tat = jobs[i].ct - jobs[i].at;
            jobs[i].wt = jobs[i].tat - jobs[i].bt;

            avgtat += jobs[i].tat;
            avgwt += jobs[i].wt;
        }

        System.out.println("Process id \t Arrival Time \t Burst Time \t Completion Time \t Turn Around Time \t Waiting time");

        for (int i = 0; i < n; i++) {
            System.out.println(jobs[i].id + "\t\t\t\t" + jobs[i].at + "\t\t\t\t" + jobs[i].bt + "\t\t\t\t"
                    + jobs[i].ct + "\t\t\t\t\t" + jobs[i].tat + "\t\t\t\t\t" + jobs[i].wt);
        }

        System.out.println("Average waiting time " + (avgwt / n));
        System.out.println("Average turn around time " + (avgtat / n));

    }
}
