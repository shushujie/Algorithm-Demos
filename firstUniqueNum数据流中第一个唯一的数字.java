import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        dataStream data = new dataStream();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            data.add(num);
            if(num == number) break;
        }

        if (!data.contains(number)) {
            return -1;
        }

        ListNode first = data.dummyhead.next;
        return first == null ? -1 : first.val;



    }


}

class dataStream {
    ListNode dummyhead;
    ListNode tail;
    HashMap<Integer, ListNode> num2pre;//gives the previous listNode;
    //if it gives null for the previous listnod, it mean the num has been removed

    public dataStream() {
        dummyhead = new ListNode(0);
        tail = dummyhead;
        num2pre = new HashMap<>();
    }
    public boolean add(int num) {

        if (num2pre.containsKey(num) ) {
            if (num2pre.get(num) == null) {
                return false;
            }

            remove(num);
            num2pre.put(num, null);
            return false;
        }

        pushBack(num);

        return true;
    }

    public boolean remove(int num) {
        if (!num2pre.containsKey(num)) return false;
        ListNode prev = num2pre.get(num);
        ListNode node = prev.next;

        if (node == tail ) {
            prev.next = null;
            tail = prev;
            num2pre.remove(num);
            return true;
        }

        ListNode next = prev.next.next;
        prev.next = next;
        num2pre.put(next.val, prev);

        return true;
    }

    public void pushBack(int num) {
        tail.next = new ListNode(num);
        num2pre.put(num, tail);
        tail = tail.next;
        return;

    }

    public boolean contains(int number) {
        if (num2pre.containsKey(number)) return true;
        return false;
    }


}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int num) {
        this.val = num;
        this.next = null;
    }
}