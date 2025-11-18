package stackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//单调递减队列解法
public class SlidingWindowMaximum {

    public static int[] getMaximum(int[] arr,int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> maximumList = new ArrayList<>();
        int left = 0, right = k-1;
        deque.offerLast(0);

        // 将第一个滑动窗口的元素加入单调递减队列
        for(int i = 1; i<=right;i++){
            if(arr[deque.peekLast()] > arr[i]){
                deque.offerLast(i);
                continue;
            }
            addElement(arr,deque,i);
        }

        //窗口开始移动
        while(right < arr.length){
            while(deque.peekFirst() < left){
                deque.pollFirst();
            }
            addElement(arr,deque,right);
            maximumList.add(arr[deque.peekFirst()]);
            left++;
            right++;
        }
        return maximumList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void addElement(int[] arr, Deque<Integer> deque, int right){
        while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[right]) {
            deque.pollLast();
        }
        deque.offerLast(right);
    }

    public static void main(String[] args){

        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(getMaximum(arr,k));
    }

}

/*
//暴力解法，时间复杂度 O( N * k)
public class SlidingWindowMaximum {

    public static int[] getMaximum(int[] arr,int k){
        int left = 0, right = k-1;
        List<Integer> maximumList = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i=left; i <= right; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        maximumList.add(max);

        while(right <= arr.length-1){
            left++;
            right++;
            if(arr[left] > max) {
                max = arr[left];
            }
            if(arr[right] > max){
                max = arr[right];
            }
            maximumList.add(max);
        }
        return maximumList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}


//时间复杂度最差为 O(N2)，但是平均时间复杂度比暴力解法更优，跑通了 leetcode 测试用例
public class SlidingWindowMaximum {

    public static int[] getMaximum(int[] arr,int k){
        int left = 0, right = k-1;
        List<Integer> maximumList = new ArrayList<>();
        int max = -1;
        //开始进入滑动窗口
        while(right < arr.length){
            if(max<left){
                int maxValue = Integer.MIN_VALUE;
                //如果 max 落后于当前滑动窗口，则滑动窗口内重新确定最大值
                for(int i=left; i <= right; i++){
                    if(arr[i] >= maxValue){
                        max = i;
                        maxValue = arr[i];
                    }
                }
            }
            //如果 max 位于当前滑动窗口，那么仅需比较新移入的右侧元素即可确定最大值
            if(arr[right] > arr[max]){
                max = right;
            }
            maximumList.add(arr[max]);
            left++;
            right++;
        }
        return maximumList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
 */
