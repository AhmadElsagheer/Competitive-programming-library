import java.util.Scanner;

public class DAA_shellSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no. of values:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values:");
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }
        ShellSort(arr);
        System.out.println("Array after sorting:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void ShellSort(int[] arr){
        int n = arr.length;
        int gap = n/2;
        while(gap>0){
            for(int i=gap;i<n;i+=gap){
                int j=i-gap;
                int temp = arr[i];
                while(j>=0 && arr[j]>temp){
                    arr[j+gap] = arr[j];
                    j-=gap;
                }
                arr[j+gap]=temp;
            }
            gap/=2;
        }
    }
}
