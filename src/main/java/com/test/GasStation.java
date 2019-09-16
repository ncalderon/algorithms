package com.test;

import java.util.Arrays;
import java.util.LinkedList;

public class GasStation {
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
