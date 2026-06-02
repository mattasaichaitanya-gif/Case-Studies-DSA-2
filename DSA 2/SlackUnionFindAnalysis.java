public class SlackUnionFindAnalysis {

    public static void main(String[] args) {

        // Given Data
        int channels = 12000;

        int membershipEdges = 240000;

        // --------------------------------------
        // (i) Time Complexity
        // --------------------------------------

        System.out.println("SLACK CHANNEL-MEMBERSHIP GRAPH");
        System.out.println("----------------------------------");

        System.out.println("\n(i) TIME COMPLEXITY");

        System.out.println(
                "Using Union-Find with Path Compression "
                + "and Union-by-Rank:");

        System.out.println(
                "Time Complexity = O(E × α(V))");

        System.out.println(
                "Where:");

        System.out.println(
                "E = Number of edges = "
                + membershipEdges);

        System.out.println(
                "V = Number of channels = "
                + channels);

        System.out.println(
                "α(V) = Inverse Ackermann Function "
                + "(almost constant)");

        System.out.println(
                "Practical Complexity ≈ O(E)");

        // --------------------------------------
        // (ii) Find Operations
        // --------------------------------------

        System.out.println("\n(ii) FIND OPERATIONS");

        // Each union operation needs 2 find() calls
        int totalFindOperations =
                membershipEdges * 2;

        System.out.println(
                "Total find() operations = "
                + totalFindOperations);

        // Approximate pointer hops
        // Path compression makes average depth very small
        int averagePointerHops = 3;

        long totalPointerHops =
                (long) totalFindOperations
                * averagePointerHops;

        System.out.println(
                "Approximate pointer hops per find() = "
                + averagePointerHops);

        System.out.println(
                "Total Pointer Hops ≈ "
                + totalPointerHops);

        // --------------------------------------
        // (iii) Largest Component Size
        // --------------------------------------

        System.out.println("\n(iii) LARGEST COMPONENT SIZE");

        System.out.println(
                "After all union operations are completed,");

        System.out.println(
                "we maintain a size array for each root node.");

        System.out.println(
                "Whenever two components are merged,");

        System.out.println(
                "their sizes are added and stored in the new root.");

        System.out.println(
                "Finally, we scan all root nodes once and");

        System.out.println(
                "select the maximum component size.");

        System.out.println(
                "This requires O(V) additional time.");

    }
}