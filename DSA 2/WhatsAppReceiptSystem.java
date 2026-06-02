public class WhatsAppReceiptSystem {

    public static void main(String[] args) {

        // Given Data
        int messagesPerSecond = 5000;
        int peakHourSeconds = 3600;

        // Total messages
        long totalMessages =
                (long) messagesPerSecond * peakHourSeconds;

        // Plain BST height
        long bstHeight = totalMessages;

        // AVL Tree height approximation
        double avlHeight =
                Math.log(totalMessages) / Math.log(2);

        // Pointer hop cost
        double pointerHopNs = 200;

        // Worst-case latency
        double bstLatencyUs =
                (bstHeight * pointerHopNs) / 1000;

        double avlLatencyUs =
                (Math.ceil(avlHeight) * pointerHopNs) / 1000;

        // SLA
        double SLA = 500;

        // Output
        System.out.println("WHATSAPP DELIVERED-RECEIPTS ORDERING");
        System.out.println("-----------------------------------");

        System.out.println("Messages per second: "
                + messagesPerSecond);

        System.out.println("Peak hour duration: "
                + peakHourSeconds + " seconds");

        System.out.println("Total messages: "
                + totalMessages);

        // Plain BST Analysis
        System.out.println("\nPLAIN BST ANALYSIS");

        System.out.println("Tree Shape: "
                + "Skewed Tree (Linked List)");

        System.out.println("Expected Height: "
                + bstHeight);

        System.out.println("Worst-case pointer hops: "
                + bstHeight);

        System.out.println("Worst-case latency: "
                + bstLatencyUs
                + " microseconds");

        // AVL Analysis
        System.out.println("\nAVL TREE ANALYSIS");

        System.out.println("Expected Height: "
                + Math.ceil(avlHeight));

        System.out.println("Worst-case pointer hops: "
                + Math.ceil(avlHeight));

        System.out.println("Worst-case latency: "
                + avlLatencyUs
                + " microseconds");

        // SLA Check
        System.out.println("\nSLA CHECK");

        if (bstLatencyUs > SLA) {
            System.out.println("Plain BST FAILS SLA");
        } else {
            System.out.println("Plain BST PASSES SLA");
        }

        if (avlLatencyUs > SLA) {
            System.out.println("AVL Tree PASSES SLA");
        } else {
            System.out.println("AVL Tree FAILS SLA");
        }
    }
}