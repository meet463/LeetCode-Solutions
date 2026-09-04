/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        // reversal
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // hare & turtle approach
    public ListNode findMiddle(ListNode head) {
        ListNode Rabbit = head;
        ListNode Turtle = head;
        // rabbit always take 2 step 
        // turtle 1 step at a time 

        while(Rabbit.next != null && Rabbit.next.next != null) {
            Rabbit = Rabbit.next.next;
            Turtle = Turtle.next;
        }
        return Turtle;
    }


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head); // 1st half ka end
        ListNode secondHalfStart = reverse(middle.next); // 2nd half ka ele ko reverse karenga

        ListNode firstHalfStart = head;
        while(secondHalfStart != null) {
            if(firstHalfStart.val != secondHalfStart.val) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
        
    }
}