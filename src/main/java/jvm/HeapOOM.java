package jvm;

import java.util.ArrayList;

/**
 * Created by nathan on 18/1/1.
 */
public class HeapOOM {
    public static void main(String[] args) {
        ArrayList<HeapOOM> heapOOMS = new ArrayList<>();
        while (true) {
            heapOOMS.add(new HeapOOM());
        }
    }
}
