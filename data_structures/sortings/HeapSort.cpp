#include <iostream> 
#include<algorithm>
#include<vector>
  
using namespace std; 
void heapify(int arr[], int n, int i) 
{ 
    int largest = i; 
    int l = 2*i + 1; 
    int r = 2*i + 2;
    if (r < n && arr[r] > arr[largest]) 
        largest = r; 
    if (l < n && arr[l] > arr[largest]) 
        largest = l; 
    if (largest != i) 
    { 
        swap(arr[i], arr[largest]); 
        heapify(arr, n, largest); 
    } 
} 
void heapSort(int arr[], int n) 
{ 
    for (int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i); 
    for (int i=n-1; i>=0; i--) 
    {
        swap(arr[0], arr[i]); 
        heapify(arr, i, 0); 
    } 
} 
int main() 
{ 
    int arr[] = {12, 14, 2, 3, 9, 8}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
  
    heapSort(arr, n); 
  
    cout << "Array after sorting is: \n"; 
    for (int i=0; i<n; ++i) 
        cout << arr[i] << " "; 
    cout << "\n"; 
} 
