package sword_finger_offer;

import java.util.Stack;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 13:38
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *  输入：head = [1,3,2]
 *  输出：[2,3,1]
 *  
 *
 * 限制：
 *  0 <= 链表长度 <= 10000
 */
public class JZ06_从尾到头打印链表 {
    /**
     * Definition for singly-linked list.
     */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public int[] reversePrint1(ListNode head) {
        ListNode h = head;
        int counter = 0;
        while (h != null){
            counter++;
            h = h.next;
        }

        int[] result = new int[counter--];
        h = head;
        while (h != null){
            result[counter--] = h.val;
            h = h.next;
        }
        return result;
    }


        public static void main(String[] args) {

    }
}
