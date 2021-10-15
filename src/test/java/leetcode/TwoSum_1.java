package leetcode;


import cn.hutool.core.util.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

public class TwoSum_1 {

    @Test
    public void run() {
        int[] nums = {1, 2, 3, 5, 6};
        int target = 2;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + "\t" + res[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] filter = Arrays.stream(nums).filter(num -> (
                num < target
        )).sorted().toArray();
        for(int num : nums) {
            int rest = target - num;
            if(rest == num) continue;
            for(int n : nums) {
                if(n == rest) return new int[]{num, target};
                if(n > rest) break;
            }
        }
        return new int[]{0, 0};
    }

}
