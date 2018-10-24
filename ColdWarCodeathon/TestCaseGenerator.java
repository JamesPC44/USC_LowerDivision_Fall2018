import java.io.*;
import java.lang.*;
import java.util.Random;

public class testCaseGenerator{
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
				//generate random string of letters COLDWAR
				//choose a number between 0-6
				letter = rand.nextInt(6);
				char[] charArray = new char[]{ 'C','O','L','D','W','A','R' }
				//choosing a random length
				length = rand.nextInt(88);
				//this is for # of lines
				for(int j = 0; j < length; j++){
					//this is for each line
					for( int t = 0; t < 1; t++){
						for( int t = 0; t < 1; t++)
						line += (charArray.get(letter));
					}
					+ " ";
				}
				input.println(line);
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