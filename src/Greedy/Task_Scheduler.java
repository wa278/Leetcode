package Greedy;

import java.util.Arrays;

public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char e : tasks) {
            map[e - 'A']++;
        }
        Arrays.sort(map);
        int max = map[25];
        int idle = (max - 1) * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle -= Math.min(map[i], max - 1);
        }
        return idle > 0 ? tasks.length + idle : tasks.length;
    }

    public static void main(String[] args) {
        Task_Scheduler x = new Task_Scheduler();
        char[] input = {'A', 'B', 'A', 'B', 'A', 'B'};
        System.out.println(x.leastInterval(input, 2));
    }
}
