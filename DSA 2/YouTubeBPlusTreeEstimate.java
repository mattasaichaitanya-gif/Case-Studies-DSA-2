public class YouTubeBPlusTreeEstimate {

    public static void main(String[] args) {

        // Given Data
        long totalRecords = 500000000L; // 5 × 10^8
        int keySize = 64; // bytes
        int payloadSize = 100; // bytes
        int pageSize = 4096; // 4 KB page
        int pointerSize = 8; // bytes
        int leafEntrySize = keySize + payloadSize;
        int leafFanout = pageSize / leafEntrySize;
        int internalEntrySize = keySize + pointerSize;
        int internalFanout = pageSize / internalEntrySize;
        double leafPages =
                Math.ceil((double) totalRecords / leafFanout);

        
        int height = 1;

        double nodes = leafPages;

        while (nodes > 1) {

            nodes = Math.ceil(nodes / internalFanout);

            height++;
        }

        int cachedLevels = 3;

        int ioCost;

        if (height <= cachedLevels) {
            ioCost = 0;
        } else {
            ioCost = height - cachedLevels;
        }


        System.out.println("YOUTUBE VIDEO CATALOG");
        System.out.println("B+ TREE SIZE ESTIMATE");
        System.out.println("--------------------------------");

        System.out.println("Total Records: "
                + totalRecords);

        System.out.println("Page Size: "
                + pageSize + " bytes");

        System.out.println("\n(i) LEAF FANOUT");

        System.out.println("Leaf Entry Size = "
                + keySize + " + "
                + payloadSize
                + " = "
                + leafEntrySize
                + " bytes");

        System.out.println("Leaf Fanout = "
                + pageSize
                + " / "
                + leafEntrySize
                + " = "
                + leafFanout
                + " entries per leaf page");

        System.out.println("\n(ii) INTERNAL NODE FANOUT");

        System.out.println("Internal Entry Size = "
                + keySize
                + " + "
                + pointerSize
                + " = "
                + internalEntrySize
                + " bytes");

        System.out.println("Internal Fanout = "
                + pageSize
                + " / "
                + internalEntrySize
                + " = "
                + internalFanout
                + " separator keys per page");

        System.out.println("\n(iii) B+ TREE HEIGHT");

        System.out.println("Leaf Pages Required = "
                + Math.ceil(leafPages));

        System.out.println("B+ Tree Height = "
                + height);

        System.out.println("\nPOINT LOOKUP I/O COST");

        System.out.println("Top 3 Levels Cached");

        System.out.println("Expected SSD Page Reads = "
                + ioCost);

    }
}