import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class sort{
    public int count;
    public void qsort(int A[],int low,int high)
    {
        if(low<high)
        {
            int pindex = partion(A, low, high);
            qsort(A, low, pindex-1);
            qsort(A, pindex+1, high);
        }
    }
    public void swap(int A[],int i,int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private int partion(int A[],int low,int high)
    {
        count = 0;
        int pivot = A[low];
        int i = low;
        int j = high;
        while (i<j){
            do{
                count++;
                i++;
            } while (A[i]<pivot && i<high );
            
            do{
                count++;
                j--;
            }while (A[j]>pivot && j>low);
            if(i<j)
            {
                swap(A, i, j);
            }
        }
        swap(A, low, j);
        return j;
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
        s.qsort(A,0,n-1);
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
          FileWriter f1 = new FileWriter("qs_best.txt");
          FileWriter f2 = new FileWriter("qs_worst.txt");
          FileWriter f3 = new FileWriter("qs_avg.txt");
          int n = 4;
          while (n<1034){
            int A[] = new int[n];
            //Best case
            for(int i = 0;i<n;i++)
            {
                A[i] = 5;
            }
            s.count =0;
            s.qsort(A, 0, n-1);
            f1.write(n+" "+s.count+"\n");
            //worst case
            for(int i =0;i<n;i++)
            {
                A[i] = i+1;
            } 
            s.count =0;
            s.qsort(A, 0, n-1);
            f2.write(n+" "+s.count+"\n");
            //Avg case
            for(int i =0;i<n;i++)
            {
                A[i] = rand.nextInt()%n;
            }    
            s.count =0;
            s.qsort(A, 0, n-1);
            f3.write(n+" "+s.count+"\n");
            n = n*2;
        }
        f1.close();
        f2.close();
        f3.close();
    }
}
public class quicksort{
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
