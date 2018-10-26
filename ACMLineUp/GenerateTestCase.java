import java.io.*;
import java.lang.*;
import java.util.Random;

public class GenerateTestCase 
{
	public static void generateCase(String input, String output) throws IOException
	{
		ProcessBuilder builder = new ProcessBuilder("java", "ACMLineUp");
		builder.redirectInput(new File(input));
		builder.redirectOutput(new File(output));
		builder.start();
	}

	public static void main(String[]args) throws IOException 
	{
		int len;
		String line = "";
		String inFile = "";
		String outFile = "";
		Random rand = new Random();
		ProcessBuilder builder;
		for(int i = 1; i < 20; i++)
		{
			try
			{
				inFile = String.format("./input/test%dInput.txt", i);
				outFile = String.format("./output/test%dOutput.txt", i);
				PrintWriter input = new PrintWriter(new BufferedWriter(new FileWriter(inFile)));
				len = rand.nextInt(101) + 1;
				input.println(len);
				for(int j = 0; j < len; j++)
					line += (rand.nextInt(5) + 1) + " ";
				input.println(line);
				input.close();
				generateCase(inFile, outFile);
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
