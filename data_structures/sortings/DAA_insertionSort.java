import java.util.*;

public class DAA_insertionSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of values");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values:");
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }
        InsertionSort(arr);
        System.out.println("Sorted array using insertion sort : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void InsertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            int temp=arr[i];
            while(j>=0 && arr[j]>temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
