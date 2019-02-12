package org.hellofalcon.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - chugang.cg
 * @create - 2019/2/12
 */
public class Test {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        if(states.length == 0) {
            return new ArrayList<>();
        }

        System.out.println("--");

        List<Integer> currentStates = new ArrayList<>(states.length);
        for(int i = 0; i < states.length; i++) currentStates.set(i, states[i]);

        for(int i = 0; i < days; i++) {
            List<Integer> nextDayStates = new ArrayList<>(currentStates.size());
            System.out.println("--");
            for(int h = 0; h < currentStates.size(); h++) {
                if(getLeftStatus(currentStates, h) == getRightStatus(currentStates, h)) {
                    nextDayStates.set(h, 1);
                } else {
                    nextDayStates.set(h, 0);
                }
            }

            currentStates = nextDayStates;
        }

        return currentStates;
    }

    private int getLeftStatus(List<Integer> states, int houseIndex) {
        if (houseIndex == 0) {
            return 0;
        }

        return states.get(houseIndex - 1);
    }

    private int getRightStatus(List<Integer> states, int houseIndex) {
        if (houseIndex == states.size() - 1) {
            return 0;
        }

        return states.get(houseIndex + 1);

    }

    public static void main(String[] args) {
        Test t = new Test();
        int[] st = new int[]{1, 0, 1, 0};
        List<Integer> integers = t.cellCompete(st, 1);
        System.out.println(integers.size());
    }
}
