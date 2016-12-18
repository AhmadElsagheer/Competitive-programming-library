package data_structures.sortings;

public class MergeSort
{
	/*
	 * - Complexity O(n log n)
	 * - Stable sort algorithm
	 * - Can be used to compute inversion index
	 */
	static final int INF = Integer.MAX_VALUE;
	
	static void mergeSort(int[] a, int b, int e)
	{
		if(b < e)
		{
			int q = (b + e) / 2;
			mergeSort(a, b, q);
			mergeSort(a, q + 1, e);
			merge(a, b, q, e);
		}
	}


    static void merge(int[] a, int b, int mid, int e)
    {
       int n1 = mid - b + 1;
       int n2 = e - mid;
       int[] L = new int[n1+1], R = new int[n2+1];
       
       for(int i = 0; i < n1; i++)  L[i] = a[b + i];
       for(int i = 0; i < n2; i++)  R[i] = a[mid + 1 + i];
       L[n1] = R[n2] = INF;
       
       for(int k = b, i = 0, j = 0; k <= e; k++)
    	   if(L[i] <= R[j])
    		   a[k] = L[i++];
    	   else
    		   a[k] = R[j++];
    }  

 }