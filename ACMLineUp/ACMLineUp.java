import java.lang.Math;
import java.io.IOException;
import java.util.Scanner;

public class ACMLineUp 
{
	public static void main(String[] args) throws IOException
	{
		Scanner reader = new Scanner(System.in);
		int len = reader.nextInt();
		int sqt = (int)Math.ceil(Math.sqrt(len));
		reader.nextLine();
		String [] line = reader.nextLine().split(" ");
		int pivot = sqt-1;
			
		for(int i = 0; i < Math.pow(sqt, 2); i++)
		{
			if ((i/sqt)%2 == 0)
			{
				if(i < len)
					System.out.print(line[i] + ',');
				else
					System.out.print("0" + ',');
			}
			else
			{
				if(i+pivot < len)
					System.out.print(line[i+pivot] + ',');		
				else
					System.out.print("0" + ',');
				pivot -= 2;
			}
			if(i % sqt == sqt-1)
			{
				System.out.print("\n");
				pivot = sqt-1;
			}
		}
		reader.close();
	}
}
