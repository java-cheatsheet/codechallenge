package datastructures;


/**
 * Count frequency of characters in a string.
 *
 * Solutions with hash implementation and
 * brute force are presented
 *
 * Source: https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/tutorial
 */
public class FrequencyCountWithHash {
    public static void main(String[] args) {
        new CountFrequency().countFrequency("aabc");
    }
}

class CountFrequency {
    private final int[] frequency = new int[26];

    private int hashFunc(char c)
    {
        return ( c - 'a' );
    }

    public void countFrequency(String S) {
        for (int i = 0; i < S.length(); i++) {
            int index = hashFunc( S.charAt(i) );
            this.frequency[index]++;
        }

        for (int i = 0; i < 26; i++)
            System.out.printf( "Character %s count %d%n",
                    Character.toString((char) i + 97 ),
                    frequency[i] );

    }

//    public void countFrequencyBruteForce( String s) {
//        for(char c = ‘a’;c <= ‘z’;++c)
//        {
//            int frequency = 0;
//            for(int i = 0;i < S.length();++i)
//                if(S[i] == c)
//                    frequency++;
//            cout << c << ‘ ‘ << frequency << endl;
//        }
//    }
}
