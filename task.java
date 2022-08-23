import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 2, 1 };
        int[] nums2 = new int[] { 2, 2 };
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> smallMap2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            smallMap2.put(i, nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (smallMap2.containsValue(nums2[i])) {
                result.add(nums2[i]);

                int key = getKey(smallMap2, nums2[i]);

                smallMap2.remove(key);

            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;

    }

    public static Integer getKey(Map<Integer, Integer> map, int value) {
        Integer key = null;
        for (Integer getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                key = getKey;
            }
        }
        return key;
    }

}