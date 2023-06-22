package algorithm.leet24;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
    }

    public ListNode swapPairs(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            listNodes.add(current);
            current = current.next;
        }
        for (int i = 0; i < listNodes.size(); i += 2) {
            if (i + 1 < listNodes.size()) {
                ListNode temp = listNodes.get(i);
                listNodes.set(i, listNodes.get(i + 1));
                listNodes.set(i + 1, temp);
            }
        }
        for (int i = 0; i < listNodes.size(); i++) {
            if (i + 1 < listNodes.size()) {
                listNodes.get(i).next = listNodes.get(i + 1);
            } else {
                listNodes.get(i).next = null;
            }
        }
        return listNodes.get(0);
    }
}
