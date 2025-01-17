package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengxiyang
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);

                if (Math.abs(i - index) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
