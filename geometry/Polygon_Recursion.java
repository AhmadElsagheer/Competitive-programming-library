import java.util.Scanner;
import java.io.*;
class Polygon
{
	public static void main(String args[])
	{
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter number of sides");
		int n=inp.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		for(int i=0;i<n;i++)
		{
			x[i] = inp.nextInt();
			y[i] = inp.nextInt();
		}
		int m=1;
		int flag1 = m+1;
		int flag2 = m+2;
		int sum=0;
		int temp=0;
		int result = Area(n,m,flag1,flag2,sum,temp);
		System.out.println("Area is "+result);
	}
	static int Area(int n,int m,int flag1,int flag2,int sum,int temp)
	{
		if(flag1>n || flag2>n)
		{
			return sum;
		}
		    temp = m*flag1*flag2;
			flag1++;
			flag2++;
			sum = sum + temp;
			return Area(n,m,flag1,flag2,sum,temp);
	}
}
