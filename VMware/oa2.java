import java.util.*;
public class Solution {
    public static void main(String[] args) {
        for(int num: mySort(new int[]{1,2,3,7,8})) {
            System.out.println(num);
        }
    }
    public static Integer[] mySort(int[] arr) {
        // return list.stream().mapToInt(i -> i).toArray();
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]:: new);
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1num = getBitsNum(o1);
                int o2num = getBitsNum(o2);
                if(o1num != o2num)
                    return o2num - o1num;
                else
                    return o2 - o1;
            }
            private int getBitsNum(Integer num) {
                int count = 0;
                while(num != 0) {
                    count += num & 1;
                    num >>= 1;
                }
                return count;
            }
        });
        return nums;
    }
}