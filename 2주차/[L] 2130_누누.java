package algorithm.leet2130;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int pairSum(ListNode head) {
        List<Integer> listNodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            listNodes.add(current.val);
            current = current.next;
        }
        int ans = 0;
        for (int i = 0; i < listNodes.size() / 2; i++) {
            ans = Math.max(ans, listNodes.get(i) + listNodes.get(listNodes.size() - i - 1));
        }
        return ans;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
