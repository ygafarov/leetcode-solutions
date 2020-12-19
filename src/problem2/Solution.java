package problem2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        sum(result, l1, l2);
        return result;

    }

    void sum(ListNode currentNode, ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + currentNode.val;
            currentNode.val = sum % 10;

            if (l1.next != null || l2.next != null || sum / 10 != 0) {
                ListNode nextNode = new ListNode(sum / 10);
                currentNode.next = nextNode;
                sum(nextNode, l1.next, l2.next);
            }

        } else if (l1 == null && l2 != null) {
            sum(currentNode, new ListNode(0), l2);
        } else if (l2 == null && l1 != null) {
            sum(currentNode, l1, new ListNode(0));
        }
    }
}