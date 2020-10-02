import java.util.Scanner;

public class DAA_bubbleSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no. of values:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values:");
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Press 1 for iterative bubble sort 2 for recursive bubble sort:");
        int choice = input.nextInt();
        if(choice==1)
            BubbleSort(arr);
        else
            BubbleSortRecursive(arr,n);
        System.out.println("Array after sorting:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //iterative solution
    static void BubbleSort(int[] arr){
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //recursive solution
    static void BubbleSortRecursive(int[] arr,int n){
        if(n-1>0){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            BubbleSortRecursive(arr,n-1);
        }

    }

}
