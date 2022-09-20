package leetcode.contest.biweekly_contest_87;

import java.util.Arrays;

public class CountDaysSpentTogether {
    public static void main(String[] args) {
        CountDaysSpentTogether s = new CountDaysSpentTogether();
        String[] str = {
                "04-20",
                "06-18",
                "04-12",
                "12-19"
        };
        System.out.println(s.countDaysTogether(str[0],str[1],str[2],str[3]));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        if(leaveAlice.compareTo(arriveBob) < 0 || leaveBob.compareTo(arriveAlice) < 0) {
            return 0;
        } else {
            String[] dates = {arriveAlice,leaveAlice,arriveBob,leaveBob};
            Arrays.sort(dates);
            return getDays(dates[1], dates[2]);
        }
    }
    public int getDays(String start, String end) {
        System.out.println(start + " " + end);
        int[] daysInMonth = {31,28,31, 30,31,30, 31,31,30,31,30,31};
        int startDate = Integer.parseInt(start.split("-")[1]);
        int startMonth = Integer.parseInt(start.split("-")[0]);;
        int endDate = Integer.parseInt(end.split("-")[1]);
        int endMonth = Integer.parseInt(end.split("-")[0]);

        if(startMonth == endMonth) {
            return endDate-startDate+1;
        }
        int days = daysInMonth[startMonth-1] - startDate + 1;
        days += endDate;
        System.out.println(days);

        while (startMonth < (endMonth-1)) {
            days += daysInMonth[startMonth];
            startMonth++;
        }
        return days;
    }
}
