import java.util.Scanner;
	public class Quicksort {
		
		static Scanner s = new Scanner(System.in);
		
		public static int[] takeInput(){
			int size = s.nextInt();
			int[] input = new int[size];
			for(int i = 0; i < size; i++){
				input[i] = s.nextInt();
			}
			return input;
		}
		
		public static void main(String[] args) {
			int[] input = takeInput();
			quickSort(input);
			for(int i = 0; i < input.length; i++) {
				System.out.print(input[i] + " ");
			}
		}
	
		public static int partition(int a[],int l,int h){	
		     int pivot = a[l];
		        int i=l;
		        int j=h;
		        int k;
		        while(i<j){
		            do{
		                i++;
		            }while(a[i]<=pivot);
		            do{
		                j--;
		            }while(a[j]>pivot);
		          if(i<j){
		             k=a[i];
		            a[i]=a[j];
		            a[j]=k;
		            }
		        }
		          
		            k=a[j];
		            a[j]=a[l];
		            a[l]=k ;   
		         return j;
		        }
		     
		    
		      public static void quick(int input[],int l,int h){
		           if(l<h){
		               int j=partition(input,l,h);
		               quick(input,l,j);
		               quick(input,j+1,h);
		           }
		       }         

		    
			public static void quickSort(int[] input) {
			        quick(input ,0,input.length-2);
					
		    }
			
		}
