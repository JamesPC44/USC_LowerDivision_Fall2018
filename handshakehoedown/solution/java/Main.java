import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int p = input.nextInt();
    int q = input.nextInt();
    int r_size = input.nextInt();
    String r_in = input.next();
    //int n = 3;
    //int p = 5;
    //int q = 5;
    //int r_size = 12;
    //String r_in = "H_PPPP___PSP";
    q = (int)r_size / p;
    if (r_size % p > 0) {
      q += 1;
    }
    //System.out.println("Q:" + q);
    String[] r = new String[q];
    
    for (int i = 0; i < q; i++) {
      //System.out.println(i);
      if (i * p < r_size) {
        r[i] = r_in.substring(i * p, (((i + 1) * p < r_size) ? ((i + 1) * p) : (r_size)));
      }
    }
    
    int hR = 0, hC = 0;
    
    for (int i = 0; i < q; i++) {
      hR = i;
      hC = r[i].indexOf("H");
      if (hC != -1) {
        break;
      }
    }
    
    int r_min = hR - n;
    int r_max = hR + n;
    int c_min = hC - n;
    int c_max = hC + n;
    
    if (r_min < 0) r_min = 0;
    if (c_min < 0) c_min = 0;
    if (r_max >= q) r_max = q;
    if (c_max >= p) c_max = p;
    
    int people = 0;
    
    //System.out.println("R-:" + r_min + " R+:" + r_max + " C-:" + c_min + " C+:" + c_max);
    
    for (int i = r_min; i < r_max; i++) {
      //System.out.println("R:" + i + " LEN:" + r[i].length());
      for (int j = c_min; j < c_max + 1 && j < r[i].length(); j++) {
        //System.out.println("CNT:" + j + " " + r[i].substring(j, j + 1));
        if (r[i].substring(j, j + 1).equals("P")) {
          people += 1;
        }
      }
    }
    System.out.println(people);
  }
}
