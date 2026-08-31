class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head; // Empty or single node
        }

        ListNode prevNode = null; // Previous node
        ListNode currNode = head; // Current node

        while (currNode != null) {
            ListNode nextNode = currNode.next; // Save next node

            currNode.next = prevNode; // Reverse link

            prevNode = currNode; // Move prev forward
            currNode = nextNode; // Move curr forward
        }

        return prevNode; // New head
    }
}