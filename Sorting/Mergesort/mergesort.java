package Sorting.Mergesort;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class sort{
    public int count;
    public void msort(int A[],int low,int high)
    {
        if(low<high)
        {
            int mid = (low+high)/2;
            msort(A, low, mid);
            msort(A, mid+1, high);
            merge(A,low,mid,high);
        }
    }
    public void merge(int A[],int low,int mid,int high)
    {
        int temp[] = new int[(high - low) + 1];
        int left = low;
        int right = mid+1;
        int i = 0;
        while (left<=mid && right<=high){
            count++;
            if(A[left]<A[right])
            {
                temp[i++] = A[left++];
            }
            else{
                temp[i++] = A[right++];
            }
        }
        while (left<=mid){
            temp[i++] = A[left++];
        }
        while (right<=high){
            temp[i++] = A[right++];
        }
        for(int j = 0;j<temp.length;j++)
        {
            A[low+j] = temp[j];
        }
    }

}
class tester
{
    Scanner sc = new Scanner(System.in);
    sort s = new sort();
    public void test()
    {
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int A[] = new int[n];
        System.out.println("Enter the elements of arrays");
        for(int i = 0;i<n;i++)
        {
            A[i] = sc.nextInt();
        }
        System.out.println("Array of elements before sorting");
        for(int i = 0;i<n;i++)
        {
            System.out.println(A[i]);
        }
        s.msort(A,0,n-1);
        System.out.println("Array of elements after sorting");
        for(int i = 0;i<n;i++)
        {
            System.out.println(A[i]);
        }   
    }
}
class plotter{
    sort s = new sort();
    public void plot()throws IOException
    {
          Random rand = new Random();
          FileWriter f1 = new FileWriter("ms_best.txt");
          FileWriter f2 = new FileWriter("ms_worst.txt");
          FileWriter f3 = new FileWriter("ms_avg.txt");
          FileWriter f4 = new FileWriter("worstdata.txt");
          int n = 2;
          while (n<=1024){
            int A[] = new int[n];
            //Best case
            for(int i =0;i<n;i++)
            {
                A[i] = i+1;
            }
            s.count = 0;
            s.msort(A, 0, n-1);
            f1.write(n+" "+s.count+"\n");
            //worst case
            s.count = 0;
            generateWorstCase(A, 0, n-1);
            for(int i =0;i<n;i++)
            {
                f4.write(A[i]+" ");
            }
            f4.write("\n");
            s.msort(A, 0, n-1);
            f2.write(n+" "+s.count+"\n");
            //avg case
            for(int i =0;i<n;i++)
            {
                A[i] = rand.nextInt()%n;
            }
            s.count =0;
            s.msort(A, 0, n-1);
            f3.write(n+" "+s.count+"\n");
            n = n*2;
          }
          f1.close();
          f2.close();
          f3.close();
          f4.close();
        }
        private void generateWorstCase(int A[], int beg, int end) {
            if (beg < end) {
                int mid = (beg + end) / 2;
                int n1 = mid - beg + 1;
                int n2 = end - mid;
    
                int[] left = new int[n1];
                int[] right = new int[n2];
    
                for (int i = 0; i < n1; i++) {
                    left[i] = A[beg + i];
                }
                for (int i = 0; i < n2; i++) {
                    right[i] = A[mid + 1 + i];
                }
    
                generateWorstCase(left, 0, n1 - 1);
                generateWorstCase(right, 0, n2 - 1);
    
                for (int i = 0; i < n1; i++) {
                    A[beg + 2 * i] = left[i];
                }
                for (int i = 0; i < n2; i++) {
                    A[beg + 2 * i + 1] = right[i];
                }
            }
        }
}

public class mergesort{
   
    public static void main(String args[]){
       
         int choice ;
         tester t= new tester();
         plotter p = new plotter();
         Scanner sc = new Scanner(System.in);
         do{
               System.out.println("1.Tester\n2.Plotter\n3.Exit\n");
               System.out.println("Enter your choice");
               choice = sc.nextInt();
               switch (choice) {
                case 1:
                       t.test();  
                      break;
                case 2:
                    try{
                        p.plot();
                       }
                       catch(IOException e)
                       {
                        System.out.println(e);
                       }
                        break;
                case 3:
                        System.out.println("--Exiting--");
                        break;
               }
         }while(choice!=3);
         
    }
}
