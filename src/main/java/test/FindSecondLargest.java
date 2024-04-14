package test;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 9, 0};
        int secondLargest = findSecondLargest(arr);
        System.out.println(secondLargest);
    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
