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
            res = res + s1; 

            /*
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
            */ 
        } 
        return res; 
    }


	//driver method
	public static void main(String[] args) throws Exception {
		
		coldwarSolution ob = new coldwarSolution();
        //initializing variables
		Vector<Integer> valueVector = new Vector<Integer>();
        int total = 0;
		int x;
        int y;

        //reading in file
		File file = new File("Data");
		Scanner sc = new Scanner(file);
        //populate vector with the data
		while (sc.hasNext()){
			valueVector.add(ob.romanToDecimal(sc.next()));
		}
        //printing data (values are odd, years are even)
        for( int i = 0; i < valueVector.size(); i++ ){
            System.out.println(valueVector.get(i));
        }
        //getting the year range values
        x = valueVector.get(valueVector.size() - 2);
        y = valueVector.get(valueVector.size() - 1);

        //count by two to get all of the dates
        for( int i = 1; i < valueVector.size() - 2; i += 2 ){
            if( (x <= (valueVector.get(i))) && ((valueVector.get(i)) <= y) ) { 
                //subtract one to get the value behind it
                total = total + valueVector.get(i - 1); 
            }
        }





        System.out.println("Total number infected between " + x + " and " + y + " is "  + total);
	}
}



