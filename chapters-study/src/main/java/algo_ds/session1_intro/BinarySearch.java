package algo_ds.session1_intro;

public class BinarySearch extends SearchAlgorithm{
    @Override
    /**
     * It uses te Divide and Conquer Strategy
     * THIS IS THE WHILE LOOP VERSION
     * @param arr
     * @param n
     * @Complexity O(log base 2 N): This is a really fast algorithm
     * @return element position
     */
    public int search(int[] arr, int n){
        int minIndex = 0;
        int maxIndex = arr.length;
        int midPos = (maxIndex+minIndex)/2;
        while (arr[midPos] != n){
            if(n > arr[arr.length-1] || n < arr[0]) return -1;
            if(n > arr[midPos]) {
                minIndex = midPos;
            }
            else {
                maxIndex = midPos;
            }
            midPos = (maxIndex+minIndex)/2;
        }
        return midPos;
    }

    private static int binarySearchIter(int[] arr, int n,int minPos,int maxPos){
        int midPos = (maxPos+minPos)/2;
        if(n > arr[arr.length-1] || n < arr[0]) return -1;
        if(arr[midPos] == n) return midPos;
        if(n > arr[midPos]) return binarySearchIter(arr, n , midPos, maxPos);
        else  return binarySearchIter(arr, n , minPos, midPos);
    }

    public static int binarySearchRecursive(int[] inArr, int number){
        return binarySearchIter(inArr, number , 0, inArr.length);
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{3,7,20,32,45,55,60,75}, 60));
    }
}
