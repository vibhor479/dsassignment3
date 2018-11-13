import java.util.*;
class Node {
    Node next;
    int data;

    public Node(int value) {
        data = value;
    }
}

public class lipalind {

        static Node reverse(Node head) {

            Node prev = null;
            Node current = head;
            Node next;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
            return head;
        }

        static public boolean isPalindrome(Node head) {

            Node current = head;
            int length = 0;


            while (current != null) {
                current = current.next;
                length++;
            }

            int mid = length % 2 == 0 ? length / 2 + 1 : length / 2 + 2;

            int idx = mid;
            current = head;


            while (idx > 1) {
                current = current.next;
                idx--;
            }

            Node head1 = reverse(current);

            boolean isPalindrome = true;
            idx = length / 2;
            current = head;


            while (idx > 0) {

                if (current.data != head1.data) {
                    isPalindrome = false;
                    break;
                }
                current = current.next;
                head1 = head1.next;
                idx--;
            }

            return isPalindrome;
        }

        public static void main(String[] args) {

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(2);
            head.next.next.next.next = new Node(1);

            System.out.println(isPalindrome(head));
        }
    }