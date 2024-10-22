package com.test;

import java.util.Arrays;
import java.util.LinkedList;

public class GasStation {
    /**
     * Challenge
     * Have the function GasStation(strArr) take strArr which will be an an array consisting of the following elements:
     * N which will be the number of gas stations in a circular route and each subsequent element will be the string g:c where
     * g is the amount of gas in gallons at that gas station and c will be the amount of gallons of gas needed to get to the following gas station.
     * For example strArr may be: ["4","3:1","2:2","1:2","0:1"]. Your goal is to return the index of the starting gas station that will allow
     * you to travel around the whole route once, otherwise return the string impossible. For the example above, there are 4 gas stations,
     * and your program should return the string 1 because starting at station 1 you receive 3 gallons of gas and spend 1 getting to the next station.
     * Then you have 2 gallons + 2 more at the next station and you spend 2 so you have 2 gallons when you get to the 3rd station.
     * You then have 3 but you spend 2 getting to the final station, and at the final station you receive 0 gallons and you spend your
     * final gallon getting to your starting point. Starting at any other gas station would make getting around the route impossible, so the answer is 1.
     * If there are multiple gas stations that are possible to start at, return the smallest index (of the gas station). N will be >= 2.
     *
     * Hard challenges are worth 15 points and you are not timed for them.
     *
     * Sample Test Cases
     * Input:new String[] {"4","1:1","2:2","1:2","0:1"}
     *
     * Output:"impossible"
     *
     * Input:new String[] {"4","0:1","2:2","1:2","3:1"}
     *
     * Output:"4"
     *
     * @param strArr
     * @return
     */
    public static String GasStation(String[] strArr) {
        int stations = Integer.parseInt(strArr[0]);
        LinkedList<String> route;
        int index = -1;
        for (int i = 0; i < stations; i++) {
            route = new LinkedList<>(Arrays.asList(strArr));
            route.remove(0);
            if(travel(0, i, route).equalsIgnoreCase("possible")){
                index = i;
                break;
            }
        }

        if(index == -1)
            return "impossible";
        else
            return (index+1) + "";
    }

    private static String travel(int remainingGallons, int idx, LinkedList<String> route){
        if(idx == route.size())
            idx = 0;
        String gc[] = route.remove(idx).split(":");
        int g = Integer.parseInt(gc[0]);
        int c = Integer.parseInt(gc[1]);
        int newRemainingGallons = remainingGallons+g-c;
        if(newRemainingGallons < 0 && route.size() > 0)
            return "impossible";
        if(route.size() == 0)
            return "possible";
        return travel(newRemainingGallons, idx++, route);
    }
}
