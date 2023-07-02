package algorithm.leet373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 10}, new int[]{2, 4, 6}, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Item> pq = new PriorityQueue<>();
        for (int num1 : nums1) {
            pq.add(new Item(num1, nums2[0], 0));
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0) {
            if (pq.isEmpty()) {
                return result;
            }
            Item first = pq.poll();
            if (first.secondIndex != nums2.length - 1) {
                int secondIndex = first.secondIndex + 1;
                pq.add(new Item(first.firstItem, nums2[secondIndex], secondIndex));
            }
            result.add(List.of(first.firstItem, first.secondItem));
        }
        return result;
    }
}

class Item implements Comparable<Item> {

    int firstItem;
    int secondItem;
    int secondIndex;

    public Item(int firstItem, int secondItem, int secondIndex) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.secondIndex = secondIndex;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(firstItem + secondItem, o.firstItem + o.secondItem);
    }
}
