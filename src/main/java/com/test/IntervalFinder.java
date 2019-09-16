package com.test;

public class IntervalFinder {

    private int[] A;
    private int[] B;

    public IntervalFinder() {
        this.A = new int[]{
                1,
                12,
                42,
                70,
                36,
                -4,
                43,
                15
        };

        this.B = new int[] {
                5,
                15,
                44,
                72,
                36,
                2,
                69,
                24
        };
    }

    public int execute () {
        return solution(A, B);
    }

    private int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int[] Aintervals = new int[A.length];
        int[] Bintervals = new int[B.length];
        int counter = 0;
        boolean add = true;
        for (int i = 0; i < A.length; i++) {
            if(counter == 0 ){
                Aintervals[counter] = A[i];
                Bintervals[counter] = B[i];
                counter++;
                continue;
            }

            add = true;
            for (int index = 0; index < Aintervals.length; index++) {
                if(Aintervals[index] <= A[i] && B[i] <= Bintervals[index]){
                    add = false;
                    break;
                } else if (A[i] <= Aintervals[index] && Bintervals[index] <= B[i]){
                    add = false;
                    Aintervals[index] = A[i];
                    Bintervals[index] = B[i];
                    break;
                } else if (Aintervals[index] <= A[i] && A[i] <= Bintervals[index]){
                    add = false;
                    Bintervals[index] = B[i];
                    break;
                } else if (Aintervals[index] <= B[i] && B[i] <= Bintervals[index]){
                    add = false;
                    Aintervals[index] = A[i];
                    break;
                }
            }

            if(add) {
                Aintervals[counter] = A[i];
                Bintervals[counter] = B[i];
                counter++;
            }
        }
        return counter;
    }
}
