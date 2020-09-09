import java.util.*;

public class Whiteborad {
    public static void main(String[] args) { new HashFunction().countFre("aabc");}
}

final class HashFunction {
    private final int[] frequency = new int[26];

    private int hashFunc(char c)
    {
        return ( c - 'a' );
    }

    public void countFre(String S) {
        for (int i = 0; i < S.length(); i++) {
            int index = hashFunc( S.charAt(i) );
            this.frequency[index]++;
        }

        for (int i = 0; i < 26; i++)
            System.out.printf( "Character %s count %d%n",
                    Character.toString((char) i + 97 ),
                    frequency[i] );

    }
}