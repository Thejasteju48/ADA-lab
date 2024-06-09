package bubblesort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class sort{
    public int count;
    public void Bubblesort(int A[])
    {
        count = 0;
        int flag,temp ;
        for(int i =0;i<=A.length-2;i++)
        {
            flag = 0;
            for(int j = 0;j<=A.length-2-i;j++)
            {
                if(A[j]>A[j+1])
                {
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    flag = 1;
                    count++;
                }
            }
            if(flag == 0)
            {
                break;
            }
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
        s.Bubblesort(A);
        System.out.println("Array of elements after sorting");
        for(int i = 0;i<n;i++)
        {
            System.out.println(A[i]);
        }   
    }
}
class plotter
{
    sort s = new sort();
    public void plot()throws IOException
    {
        FileWriter f1 = new FileWriter("bubblebest.txt");
        FileWriter f2 = new FileWriter("bubbleavg.txt");
        FileWriter f3 = new FileWriter("bubbleworst.txt");
        Random rand = new Random();
        int n = 10;
        while (n<=30000){
            int A[] = new int[n];
            //BEST CASE
            for(int i=0;i<n;i++)
            {
                A[i] = i+1;
            }
            s.Bubblesort(A);
            f1.write(n+" "+s.count+"\n");
            //AVEGRAGE CASE
            for(int i = 0;i<n;i++)
            {
                A[i] = rand.nextInt()%n;
            }
            s.Bubblesort(A);
            f2.write(n+" "+s.count+"\n");
            //WORST CASE
            for(int i =0;i<n;i++)
            {
                A[i] = n-i;
            }
            s.Bubblesort(A);
            f3.write(n+" "+s.count+"\n");
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
        f2.close();
        f3.close();
    }
}
public class bbsort
{
    public static void main(String args[])
    {
         int choice ;
         bbsort b = new bbsort();
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
