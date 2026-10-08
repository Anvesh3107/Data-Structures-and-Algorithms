import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Assignment1Task3 {

    public static void main(String[] args) {

        // Generate 10,000 random integers
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(random.nextInt(100000));
        }

        System.out.println("Generated " + numbers.size() + " random integers.");
        System.out.println();
        
        // 1. BUBBLE SORT

        List<Integer> bubbleList = new ArrayList<>(numbers);
        long startTime = System.nanoTime();
        bubbleSort(bubbleList);
        long endTime = System.nanoTime();
        long bubbleTime = endTime - startTime;

        System.out.println("Bubble Sort time: " + bubbleTime + " ns");

        // 2. MERGE SORT

        List<Integer> mergeList = new ArrayList<>(numbers);
        startTime = System.nanoTime();
        mergeSort(mergeList);
        endTime = System.nanoTime();
        long mergeTime = endTime - startTime;

        System.out.println("Merge Sort time: " + mergeTime + " ns");

        // SEARCH VALUE
        // Use a value that is guaranteed to exist
        int target = mergeList.get(5000);
        System.out.println();
        System.out.println("Search value: " + target);

        // 3. LINEAR SEARCH

        startTime = System.nanoTime();
        int linearResult = linearSearch(mergeList, target);
        endTime = System.nanoTime();
        long linearTime = endTime - startTime;
        System.out.println("Linear Search index: " + linearResult);
        System.out.println("Linear Search time: " + linearTime + " ns");

        // 4. RECURSIVE BINARY SEARCH

        startTime = System.nanoTime();
        int binaryResult = binarySearch(mergeList, 0, mergeList.size() - 1, target);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;
        System.out.println("Binary Search index: " + binaryResult);

        System.out.println("Binary Search time: " + binaryTime + " ns");

        // 5. COLLECTIONS.SORT()
        
        List<Integer> collectionsSortList = new ArrayList<>(numbers);
        startTime = System.nanoTime();
        Collections.sort(collectionsSortList);
        endTime = System.nanoTime();
        long collectionsSortTime = endTime - startTime;

        System.out.println();
        System.out.println("Collections.sort() time: " + collectionsSortTime + " ns");

        // 6. COLLECTIONS.BINARYSEARCH()

        startTime = System.nanoTime();
        int collectionsBinaryResult = Collections.binarySearch(collectionsSortList, target );
        endTime = System.nanoTime();
        long collectionsBinaryTime = endTime - startTime;

        System.out.println("Collections.binarySearch() index: " + collectionsBinaryResult);

        System.out.println("Collections.binarySearch() time: " + collectionsBinaryTime + " ns");

        // 7. COLLECTIONS.REVERSE()

        Collections.reverse(collectionsSortList);
        System.out.println();
        System.out.println("Collections.reverse() completed.");

        // 8. COLLECTIONS.SHUFFLE()

        Collections.shuffle(collectionsSortList);
        System.out.println("Collections.shuffle() completed.");

        // FINAL COMPARISON

        System.out.println();
        System.out.println(" COMPARISON TABLE ");
        System.out.println("Bubble Sort              : " + bubbleTime + " ns");
        System.out.println("Merge Sort               : " + mergeTime + " ns");
        System.out.println("Collections.sort()       : " + collectionsSortTime + " ns");
        System.out.println("Linear Search            : " + linearTime + " ns");
        System.out.println("Binary Search             : " + binaryTime + " ns");
        System.out.println("Collections.binarySearch(): " + collectionsBinaryTime + " ns");
    }

    // BUBBLE SORT
    // Time Complexity: O(n²)

    public static void bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0;j < list.size() - i - 1;j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    // MERGE SORT
    // Recursive
    // Time Complexity: O(n log n)

    public static void mergeSort(List<Integer> list) {
        // Base case
        if (list.size() <= 1) {
            return;
        }

        // Find middle
        int mid = list.size() / 2;

        // Divide into two parts
        List<Integer> left =new ArrayList<>(list.subList(0, mid));

        List<Integer> right =new ArrayList<>(list.subList(mid, list.size()));
        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);
    }

    public static void merge(List<Integer> list,List<Integer> left,List<Integer> right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining left elements
        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
    // LINEAR SEARCH

    public static int linearSearch(List<Integer> list,int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
    // BINARY SEARCH
    public static int binarySearch(List<Integer> list,int low,int high,int target) {
        // Base case
        if (low > high) {
            return -1;
        }

        // Find middle
        int mid = (low + high) / 2;

        // Target found
        if (list.get(mid) == target) {
            return mid;
        }

        // Search left half
        if (target < list.get(mid)) {
            return binarySearch(list,low,mid - 1,target);
        } else {
            return binarySearch(list,mid + 1,high,target
            );
        }
    }
}