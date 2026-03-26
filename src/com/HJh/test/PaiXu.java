package com.HJh.test;

public class PaiXu {
    //若无序数组，合并两个有序数组，并排序
    /*public static void main(String[] args) {

        int[] arr1 = new int []{1,3,5,7,9};
        int[] arr2 = new int []{2,4,6,8,10};
        int[] arr3 = new int [10];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i]=arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length+i]=arr2[i];
        }

        //选择排序

        for (int i = 0; i < arr3.length; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr3.length; j++){
                if (arr3[minIndex]>arr3[j]){
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                int temp = arr3[i];
                arr3[i]=arr3[minIndex];
                arr3[minIndex]=temp;
            }
        }

        //冒泡排序

        for (int i = 0; i < arr3.length-1; i++) {
            for(int j = 0; j < arr3.length-1-i; j++){
                if (arr3[j]>arr3[j+1]){
                    int temp = arr3[j];
                    arr3[j]=arr3[j+1];
                    arr3[j+1]=temp;
                }
            }
        }





        for(int i = 0; i < arr3.length; i++){
            System.out.print(arr3[i]);
        }
        System.out.println();
    }*/


    //若有序数组
    public static void main(String[] args) {
        int[] arr1 = new int []{1,3,5,7,9};
        int[] arr2 = new int []{2,4};
        int index1 = 0;
        int index2 = 0;
        int [] arr3 = new int [arr1.length+arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            //寻找短的数组，把长的数组剩余的全填加到新的数组中
            if(index1==arr1.length){
                arr3[i]=arr2[index2];
                index2++;
                continue;
            }
            if(index2==arr2.length){
                arr3[i]=arr1[index1];
                index1++;
                continue;
            }

            //寻找两个数组中较小的
            if(arr1[index1]<arr2[index2]){
                arr3[i]=arr1[index1];
                index1++;
            }else{
                arr3[i]=arr2[index2];
                index2++;
            }
        }
        for (int i = 0; i < arr3.length; i++){
            System.out.print(arr3[i]);
        }
    }
}
