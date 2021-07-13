package models;

import java.util.Arrays;

public class OrderManager{

    public void mergeSort(int [] list){
        sort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }

    public void sort(int [] list, int start, int end){
        if(start == end){
            return;
        }
        int middle = start + ((end - start) / 2);
        sort(list, start, middle);
        sort(list, middle + 1, end);
        merge(list, start, middle, end);
    }

    public void merge(int [] list, int start, int middle, int end){
        int indexLeft = start;
        int indexRight = middle + 1;
        System.out.println(indexLeft + "-" + indexRight);
        int [] newList = new int[end - start];
        int actualPosition = 0;
        while(indexLeft < middle && indexRight < end){
            if(list[indexLeft] < list[indexRight]){
                newList[actualPosition] = list[indexLeft];
                indexLeft++;
            }else{
                newList[actualPosition] = list[indexRight];
                indexRight++;
            }
            actualPosition++;
        }
        for (int i = indexLeft; i < middle; i++) {
            newList[actualPosition++] = list[i];
        }
        for (int i = indexRight; i < end; i++) {
            newList[actualPosition++] = list[i];
        }
        System.out.println(Arrays.toString(newList));
        list = newList;
    }

    public static void main(String[] list) {
        OrderManager om = new OrderManager();
        om.mergeSort(new int []{10, 1, 4, 0});
    }
}