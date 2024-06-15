//package Searching.Binarysearch;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class search{
    public int count;
    public int bsearchtest(int A[],int key,int low,int high){
        if(low<=high)
        {
            int mid = low+(high-low)/2;
            if(A[mid]==key)
            {
                return mid;
            }
            else if(A[mid]>key)
            {
                return bsearchtest(A, key, low, mid-1);
            }
            else{
                return bsearchtest(A, key, mid+1, high);
            }
        }
        return -1;
    }
    public int bsearchplot(int A[],int key,int low,int high)
    {
        count++;
        int mid = (low+high)/2;
        if(low>high)
        {
            return count-1;
        }
        if(A[mid]==key)
        {
            return count;
        }
        else if(A[mid]>key)
        {
            return bsearchplot(A, key, low, mid-1);
        }
        else
        {
            return bsearchplot(A, key,mid+1,high);
        }
    }
}
class tester{
    Scanner sc = new Scanner(System.in);
    search s = new search();
    public void test()
    {
         System.out.println("Enter the number of elements");
         int n = sc.nextInt();
         int A[] = new int[n];
         System.out.println("Enter the elements of array");
         for(int i=0;i<n;i++)
         {
            A[i] = sc.nextInt();
         }
         System.err.println("Enter the key elements to be searched");
         int key = sc.nextInt();
         int r = s.bsearchtest(A, key, 0, n-1);
         if(r!=-1)
         {
            System.out.println("Key element is found at postion "+r);
         }
         else{
            System.out.println("Key not found");
         }
    }
}
class plotter{
    search s = new search();
    public void plot()throws IOException
    {
         Random rand = new Random();
         FileWriter f1 = new FileWriter("binarybest.txt");
         FileWriter f2 = new FileWriter("binaryavg.txt");
         FileWriter f3 = new FileWriter("binaryworst.txt");
         int n,key,r;
         n =5;
         while (n<=1024){
            int A[] = new int[n];
            // BEST CASE
            for(int i =0;i<n;i++)
            {
                A[i] = 1;
            }
            int mid = (n-1)/4;
            A[mid] = 0;
            s.count = 0;
            r = s.bsearchplot(A, 0,0 , n-1);
            f1.write(n+" "+r+"\n");
            //AVG CASE
            for(int i =0;i<n;i++)
            {
                A[i] = rand.nextInt()%n;
            }
            s.count = 0;
            r = s.bsearchplot(A, -1, 0, n-1);
            f2.write(n+" "+r+"\n");
            //WORST CASE
            for(int i = 0;i<n;i++)
            {
               A[i] = 0;
            }
            s.count = 0;
            r = s.bsearchplot(A, 1, 0, n-1);
            f3.write(n+" "+r+"\n");
            n = n*2;
         }
         f1.close();
         f2.close();
         f3.close();
    }
}
 public class binarysearch {
    public static void main(String args[])
    {
         int choice ;
         binarysearch b = new binarysearch();
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