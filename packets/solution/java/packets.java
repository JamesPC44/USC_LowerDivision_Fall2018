import java.io.*;
import java.util.*;

/* wrote this at 11PM in a car driving from Raleigh to Columbia... probably
 * could have done a better job under other circumstances. In particular, this
 * is very much not idiomatic Java... can you tell it was written by a tired C
 * programmer?
 *
 * - Charles
 */

class Packet {
    public String[] words;
    public int size;
    public int cursor;
    public int ID;

    public Packet(int numWords, int theID) {
        this.size = numWords;
        this.words = new String[numWords];
        for (int i = 0 ; i < numWords ; i ++) {
            this.words[i] = "";
        }
        this.cursor = 0;
        this.ID = theID;
    }

    public void addWord(String word) {
        this.words[this.cursor] = word;
        this.cursor ++;
    }

    public String toString() {
        String s = new String();
        for (int i = 0 ; i < this.size ; i++) {
            s += this.words[i];
            s += " ";
        }
        return s;
    }

}

class Message {
    public Packet[] message_packets;
    public int size;
    public int cursor;

    public Message(int numPackets) {
        message_packets = new Packet[numPackets];
        this.size = numPackets;
        this.cursor = 0;
        for (int i = 0 ; i < numPackets ; i ++) {
            this.message_packets[i] = null;
        }
    }

    public void addPacket(Packet p) {
        this.message_packets[p.ID] = p;
    }

    public String toString() {
        String s = new String();
        for (int i = 0 ; i < this.size ; i ++) {
            if (this.message_packets[i] == null) {
                // this message is missing at least one packet, so it should
                // be dropped from the output
                return "";
            }
            s += this.message_packets[i].toString();
        }

        // handle trailing space
        s = s.substring(0, s.length() - 1);
        return s;
    }

}

public class packets {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        Message[] messages = new Message[65536];
        String[] output;
        int msgID;
        int packetNum;
        int numPackets;
        int numWords;
        Packet current;
        int message_counter = 0;

        for (int i = 0 ; i < 65536 ; i++) {
            messages[i] = null;
        }

        while (sc.hasNext()) {
            msgID = sc.nextInt();
            packetNum = sc.nextInt();
            numPackets = sc.nextInt();
            numWords = sc.nextInt();
            current = new Packet(numWords, packetNum);

            if (messages[msgID] == null) {
                messages[msgID] = new Message(numPackets);
                /* we need to know how many messages we have seen so we know
                 * how much space to allocate for the output array */
                message_counter ++;
            }

            for (int i = 0 ; i < numWords ; i++) {
                current.addWord(sc.next());
            }

            messages[msgID].addPacket(current);
        }

        // allocate space for the output array 
        output = new String[message_counter];

        int output_index = 0;
        for (int i = 0 ; i < 65536 ; i++) {
            /* note that the toString method of Message handles dropping
             * incomplete messages */
            if (messages[i] == null) {continue;};
            output[output_index] = messages[i].toString();
            output_index ++;
        }

        /* sort the output array */
        Arrays.sort(output);

        /* output each line */
        for (int i = 0 ; i < message_counter ; i ++) {
            // sanity check to make sure we don't print empty strings
            if (output[i].equals("")) {continue;}

            System.out.println(output[i]);
        }
    }
}
