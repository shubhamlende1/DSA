package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval{
    int start;
    int end;

    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public String toString() {
        return "[%s,%s]".formatted(start,end);
    }
}
public class EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allEmps = new ArrayList<>();

        for(List<Interval> st : schedule){
            allEmps.addAll(st);
        }

        allEmps.sort((a,b)->a.start - b.start);

        int prevEnd = allEmps.get(0).end;
        List<Interval> free = new ArrayList<>();
        for (int i = 1; i < allEmps.size(); i++){
            Interval curr = allEmps.get(i);

            if(curr.start > prevEnd){
                free.add(new Interval(prevEnd,curr.start));
            }
            prevEnd = Math.max(prevEnd, curr.end);
        }

        return free;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(employeeFreeTime(List.of(
//                List.of(new Interval(1,2),new Interval(5,6)),
//                List.of(new Interval(1,3)),
//                List.of(new Interval(4,10))
//        )).toArray()));
        System.out.println(Arrays.toString(employeeFreeTime(List.of(
                List.of(new Interval(1,3),new Interval(6,7)),
                List.of(new Interval(2,4)),
                List.of(new Interval(2,5),new Interval(9,12))
        )).toArray()));

    }
}
