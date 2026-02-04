package heap;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static int connectSticks(int[] sticks) {
        if(sticks==null || sticks.length <=1) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick: sticks) {
            pq.offer(stick);
        }
        while(!pq.isEmpty() && pq.size()>1) {
            int x = pq.poll();
            int  y =  pq.poll();
            pq.offer(x+y);
        }
        return pq.poll();
    }

    public static void main(String[] args) {

        System.out.println(connectSticks(new int[]{2, 4, 3}));
    }
}
