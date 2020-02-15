import java.util.Scanner;
class CircularNumbers
{
	public static void main(String args[])
	{
		Scanner inp=new Scanner(System.in);
		int num;
		System.out.println("Enter the number of your choice.");
		num=inp.nextInt();
		int temp,temp5;
		int x=0,y=0,j,n=0,i,k=0,s;
		temp=num;
		//temp3=num;
		int temp1=0;
		while(temp!=0)
		{
			temp1=temp%10;
			temp=temp/10;
			x++;
		}
		int temp2[]=new int[x];
		while(num!=0)
		{
			temp2[y]=num%10;
			y++;
			num=num/10;
		}
		j=y;
		s=y;
			int []arr=new int[x];
			int []temp_arr=new int[x];
			n=0;
			for(i=y-1;i>=0;i--)
			{
				arr[n]=temp2[i];
				n++;					
			}
			System.out.println("Circular Permutation of given number is as follows:");
			while(s>0)
			{
				j=y;
				n=y;
				temp5=arr[y-1];
				for(i=0;i<y;i++)
				{
					if(y-2-i>=0)
					{
						arr[n-1]=arr[y-2-i];
						n--;
						temp_arr[j-1]=arr[n-1];
						j--;
					}
					else
					{
						arr[n-1]=temp5;
						temp_arr[j-1]=arr[n-1];
					}
				}
				for(j=0;j<y;j++)
				{
					System.out.print(temp_arr[j]);
				}
				System.out.println();
				s--;
			}
}
}
