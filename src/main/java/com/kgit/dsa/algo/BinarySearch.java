package com.kgit.dsa.algo;

public class BinarySearch {

    void main(){
        int[] values = new int[]{3, 6, 7, 9, 20};
        int index = binarySearch(values, 9);
        System.out.println(index);


        int result = binarySearchRecursive(values, 9, 0 , 4);
        System.out.println("recursive result = " + result);

        int a = 3;


    }

    int binarySearchRecursive(int[] values, int target, int left, int right){
        if(left >= right){
            return left;
        }

        int mid = left + (right - left) / 2;
        if(values[mid] == target){
            return mid;
        }else if(values[mid] < target){
            return binarySearchRecursive(values, target, mid+1, right);
        }else{
            return binarySearchRecursive(values, target, left, mid-1);
        }
    }

    int binarySearch(int[] values, int target){
        int left = 0;
        int right = values.length -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(values[mid] == target){
                return mid;
            }else if(values[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
