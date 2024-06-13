

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class search{
    public int count;
    public int lsearchtester(int A[],int key)
    {
        for(int i = 0;i<A.length;i++)
        {
            if(A[i]==key)
            {
                return i;
            }
        }
        return -1;
    }
    public int lsearchplot(int A[],int key)
    {
        count = 0;
        for(int i = 0;i<A.length;i++)
        {
            count++;
            if(A[i]==key)
            {
                return count;
            }
        }
        return count;

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
        for(int i = 0;i<n;i++)
        {
            A[i] = sc.nextInt();
        }
        System.out.println("Enter the key elements to be searched");
        int key = sc.nextInt();
        int m = s.lsearchtester(A, key);
        if(m!=-1){
            System.out.println("Key is found at "+m+" postion");
        }
    }
}
class plotter{
    search s = new search();
    public void plot()throws IOException
    {
      int n,key,r;
      FileWriter f1 = new FileWriter("linearbest.txt");
      FileWriter f2 = new FileWriter("linearavg.txt");
      FileWriter f3 = new FileWriter("linearworst.txt");
       n =2;
       Random rand = new Random();
       while (n<=1024){
          int A[] = new int[n];
          //best case
          for(int i =0;i<n;i++)
          {
            A[i] = 1;
          }
          r = s.lsearchplot(A, 1);
          f1.write(n+" "+r+"\n");
          //avg case
          for(int i =0;i<n;i++)
          {
            A[i] = rand.nextInt()%n;
          }
          r = s.lsearchplot(A, A[(n-1)/2]);
          f2.write(n+" "+r+"\n");
          //Worst case
          for(int i =0;i<n;i++)
          {
            A[i] = 0;
          }
          r = s.lsearchplot(A, 1);
          f3.write(n+" "+r+"\n");
          n =n*2;
       }   
       f1.close();
       f2.close();
       f3.close();
    }
}
public class linearsearch
{
    public static void main(String args[])
    {
         int choice ;
         linearsearch l = new linearsearch();
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