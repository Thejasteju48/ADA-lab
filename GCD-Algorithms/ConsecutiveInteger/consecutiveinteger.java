import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class GCD{
    public int count;
    public int consec(int m,int n)
    {
        int min;
        count = 0;
        min = (m<n)?m:n;
        while(true){
            count++;
            if(m%min==0)
            {
                count++;
                if(n%min==0)
                {
                    break;
                }
                min-=1;
            }
            else{
                min-=1;
            }
        }
        System.out.println("The GCD of "+m+" and "+n+" is "+min);
        return count;
    }
}
class tester{
    GCD g = new GCD();
    Scanner sc = new Scanner(System.in);
    public void test()
    {
         System.out.println("Enter the value of m and n");
         int m = sc.nextInt();
         int n = sc.nextInt();
         g.consec(m, n);
    }
}
class plotter{
    GCD g = new GCD();
    public void plot()throws IOException
    {
        int i,j,k,c,maxcount,mincount;
        FileWriter f1 = new FileWriter("c_best.txt");
        FileWriter f2 = new FileWriter("c_worst.txt");
        for(i =10;i<=100;i+=10)
        {
            maxcount = 0;
            mincount = 1000;
            for(j =2;j<=i;j++)
            {
                for(k=2;k<=i;k++)
                {
                    c=0;
                    c = g.consec(j, k);
                    if(c>maxcount)
                    {
                        maxcount = c;
                    }
                    if(c<mincount)
                    {
                        mincount = c;
                    }
                }
            }
            f1.write(i+" "+mincount+"\n");
            f2.write(i+" "+maxcount+"\n");
        }
        f1.close();
        f2.close();
    }
}
public class consecutiveinteger{
    public static void main(String args[])
    {
        int choice ;
         consecutiveinteger c = new consecutiveinteger();
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