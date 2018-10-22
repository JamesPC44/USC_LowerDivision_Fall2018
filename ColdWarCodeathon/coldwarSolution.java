/**
* Java solution written by Robert Carff
* ColdWarCodathon
*
* References: 
* https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
* https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
*
*/
import java.io.FileNotFoundException; 
import java.util.*;
import java.io.*;

//converting method
public class coldwarSolution 
{ 
    // This function returns value of a Roman symbol 
    int value(char r) 
    { 
        if (r == 'C') 
            return 1; 
        if (r == 'O') 
            return 5; 
        if (r == 'L') 
            return 10; 
        if (r == 'D') 
            return 50; 
        if (r == 'W') 
            return 100; 
        if (r == 'A') 
            return 500; 
        if (r == 'R') 
            return 1000; 
        return -1; 
    } 

    // Finds decimal value of a given romal numeral 
    int romanToDecimal(String str) 
    { 
        // Initialize result 
        int res = 0; 
  
        for (int i=0; i<str.length(); i++) 
        { 
            // Getting value of symbol s[i] 
            int s1 = value(str.charAt(i)); 

            // Getting value of symbol s[i+1] 
            if (i+1 <str.length()) 
            { 
                int s2 = value(str.charAt(i+1)); 
  
                // Comparing both values 
                if (s1 >= s2) 
                { 
                    // Value of current symbol is greater 
                    // or equalto the next symbol 
                    res = res + s1; 
                } 
                else
                { 
                    res = res + s2 - s1; 
                    i++; // Value of current symbol is 
                    // less than the next symbol 
                } 
            } 
            else
            { 
                res = res + s1; 
                i++; 
            } 
        } 
  
        return res; 
    }


	//driver method
	public static void main(String[] args) throws Exception {
		
		coldwarSolution ob = new coldwarSolution();

		Vector<Integer> yearVector = new Vector<Integer>();
		Vector<Integer> deathVector = new Vector <Integer>();
		
		String year;
		String death;

		File file = new File("Data");
		Scanner sc = new Scanner(file);
		while (sc.hasNext()){
			//year = sc.hasNext();

			System.out.println(ob.romanToDecimal(sc.next()));
		}

	}
}



