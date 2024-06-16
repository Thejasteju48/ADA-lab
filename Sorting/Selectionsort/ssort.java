package Sorting.Selectionsort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class sort{
    public int count;
    public void selectionsort(int A[])
    {
        int min,t;
        for(int i =0;i<A.length;i++)
        {
            min = i;
            for(int j = i+1;j<A.length;j++)
            {
                if(A[j]<A[min])
                {
                    min = j;
                }
                count++;
            }
            if(min!=i)
            {
               t = A[i];
               A[i] = A[min];
               A[min] = t;
            }
        }
    }
}
class tester{
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
        s.selectionsort(A);
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
        FileWriter f1 = new FileWriter("selectionsort.txt");
        int n = 10;
        while (n<=30000){
            int A[] = new int[n];
            //BEST CASE
            for(int i=0;i<n;i++)
            {
                A[i] = i;
            }
            s.count =0;
            s.selectionsort(A);
            f1.write(n+" "+s.count+"\n");
            if(n<10000)
            {
                n*=10;
            }
            else
            {
                n+=10000;
            }
        }
        f1.close();
    }
}
public class ssort {
    public static void main(String args[])
    {
         int choice ;
         ssort s = new ssort();
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
