import java.io.*;
import java.lang.*;
import java.util.Random;

public class TestCaseGenerator{
	

	//public String buildString()


	public static void main(String[]args) throws IOException {
		int letter;
		int length;
		int amount;
		String line = "";
		String inFile = "";
		String outFile = "";
		Random rand = new Random();
		ProcessBuilder builder;
		Process p;
		for(int i = 1; i < 30; i++){
			try
			{
				inFile = String.format("./input/test%dInput.txt", i);
				outFile = String.format("./output/test%dOutput.txt", i);
				PrintWriter input = new PrintWriter(new BufferedWriter(new FileWriter(inFile)));
				//number of lines we want
				amount = rand.nextInt((60 - 1) + 1) + 1;
				for(int z = 0; z < amount; z++)
				{
						//generate random string of letters C O L D W A R
						char[] charArray = new char[]{ 'C','O','L','D','W','A','R' };
						String string1 = "";
						String string2 = "";
						String string3 = "";
						//choosing a random length for string
						int length1 = rand.nextInt((6 - 1 ) + 1) + 1;
						//this is for each string
						for(int j = 0; j < length1; j++)
						{
							//choose a number between 0-6
							letter = rand.nextInt(6);
							//push it onto the line
							string1 += (charArray[letter]);
							//input.println(string1);
						}
						int length2 = rand.nextInt((6 - 1 ) + 1) + 1;
						for(int j = 0; j < length2; j++)
						{
							//choose a number between 0-6
							letter = rand.nextInt(6);
							//push it onto the line
							string2 += (charArray[letter]);
							//input.println(string);
						}
					string3 += string1 + " " + string2;
					input.println(string3);
				}

				input.close();
				builder = new ProcessBuilder("java", "coldwarSolution", "<", inFile, ">", outFile);
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