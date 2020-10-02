import java.util.*;

public class DAA_SelectionSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of values");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values:");
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }
        SelectionSort(arr);
        System.out.println("Sorted array using selection sort : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void SelectionSort(int[] arr){
        int n = arr.length;
        int minIndex;
        for(int i=0;i<n-1;i++){
            minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
