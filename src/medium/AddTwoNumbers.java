package medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ));
        System.out.println(addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9)))))))
        ));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode currentResultNode = resultNode;
        int remainder = 0;
        while (l1 != null || l2 != null || remainder != 0) {
            int valueL1 = l1 != null ? l1.val : 0;
            int valueL2 = l2 != null ? l2.val : 0;
            int sum = valueL1 + valueL2 + remainder;
            remainder = sum / 10;
            currentResultNode.next = new ListNode(sum % 10);
            currentResultNode = currentResultNode.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return resultNode.next;
    }

    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        StringBuilder numberBuilder = new StringBuilder();
        int valueL1, valueL2;
        int result;
        int remainder = 0;
        while (currentL1 != null || currentL2 != null) {
            if (currentL1 != null) {
                valueL1 = currentL1.val;
                currentL1 = currentL1.next;
            } else {
                valueL1 = 0;
            }
            if (currentL2 != null) {
                valueL2 = currentL2.val;
                currentL2 = currentL2.next;
            } else {
                valueL2 = 0;
            }
            result = valueL1 + valueL2 + remainder;
            remainder = result / 10;
            numberBuilder.append(result % 10);
        }
        if (remainder != 0) {
            numberBuilder.append(remainder);
        }
        ListNode l3 = new ListNode();
        ListNode currentL3 = l3;
        for (int i = 0; i < numberBuilder.length(); i++) {
            currentL3.val = Character.getNumericValue(numberBuilder.charAt(i));
            if (i != numberBuilder.length() - 1) {
                currentL3.next = new ListNode();
                currentL3 = currentL3.next;
            }
        }
        return l3;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        String nextNode = this.next == null ? "" : this.next.toString();
        return "[" + this.val + " " + nextNode + "]";
    }
}
