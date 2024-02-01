package questions;

public class TraceLinkQuestion {
    static class Students {
        String name;
        String subject;
        int marks;
    }
    public static void main(String[] args) {
        Students[] obj = new Students[15];
        for(int i = 0; i < 15; i++) {
            obj[i] = new Students();
        }

        obj[0].name = "A";
        obj[0].subject = "S1";
        obj[0].marks = 40;

        obj[1].name = "A";
        obj[1].subject = "S2";
        obj[1].marks = 50;

        obj[2].name = "A";
        obj[2].subject = "S3";
        obj[2].marks = 40;

        obj[3].name = "A";
        obj[3].subject = "S4";
        obj[3].marks = 30;

        obj[4].name = "A";
        obj[4].subject = "S5";
        obj[4].marks = 50;

        obj[5].name = "B";
        obj[5].subject = "S1";
        obj[5].marks = 10;

        obj[6].name = "B";
        obj[6].subject = "S2";
        obj[6].marks = 30;

        obj[7].name = "B";
        obj[7].subject = "S3";
        obj[7].marks = 20;

        obj[8].name = "B";
        obj[8].subject = "S4";
        obj[8].marks = 30;

        obj[9].name = "B";
        obj[9].subject = "S5";
        obj[9].marks = 20;

        obj[10].name = "C";
        obj[10].subject = "S1";
        obj[10].marks = 40;

        obj[11].name = "C";
        obj[11].subject = "S2";
        obj[11].marks = 40;

        obj[12].name = "C";
        obj[12].subject = "S3";
        obj[12].marks = 10;

        obj[13].name = "C";
        obj[13].subject = "S4";
        obj[13].marks = 50;

        obj[14].name = "C";
        obj[14].subject = "S5";
        obj[14].marks = 30;


        int maxi = Integer.MIN_VALUE;
        int total = 0;
        String prev = obj[0].name;
        String maxiPrev = obj[0].name;

        for(int i = 0; i < obj.length; i++) {
            if(prev.equals(obj[i].name)) {
                total += obj[i].marks;
                prev = obj[i].name;
            }
            else {
                if(maxi < total) {
                    maxi = total;
                    maxiPrev = prev;
                }
                total = obj[i].marks;
                prev = obj[i].name;
            }
        }

        if(maxi < total) {
            maxi = total;
            maxiPrev = prev;
        }

        System.out.println(maxiPrev + " " +maxi);
    }
}
