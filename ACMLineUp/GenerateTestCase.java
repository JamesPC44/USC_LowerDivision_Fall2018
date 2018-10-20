import java.io.*;
import java.lang.*;
import java.util.Random;

public class GenerateTestCase 
{
	public static void main(String[]args) throws IOException 
	{
		int len;
		String line = "";
		String inFile = "";
		String outFile = "";
		Random rand = new Random();
		ProcessBuilder builder;
		Process p;
		for(int i = 1; i < 20; i++)
		{
			try
			{
				inFile = String.format("./input/test%dInput.txt", i);
				outFile = String.format("./output/test%dOutput.txt", i);
				PrintWriter input = new PrintWriter(new BufferedWriter(new FileWriter(inFile)));
				len = rand.nextInt(101);
				input.println(len);
				for(int j = 0; j < len; j++)
					line += (rand.nextInt(5) + 1) + " ";
				input.println(line);
				input.close();
				builder = new ProcessBuilder("java", "ACMLineUp", "<", inFile, ">", outFile);
				p = builder.start();
			}
			catch (Throwable t)
			{
				t.printStackTrace();
			}
			finally
			{
				System.out.println("case " + i + " generated");
			}
			
		}
	}
}
