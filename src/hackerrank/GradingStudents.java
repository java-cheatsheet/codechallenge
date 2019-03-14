package hackerrank;

import java.util.Arrays;
import java.util.List;

public class GradingStudents {

    public static void main(String args[]) {
        shouldRound73To75();
        shouldNotRoud67();
    }

    public static void shouldRound73To75() {
        int result = roundGrade( 73 );
        int expected = 75;
        assert ( result == expected ) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldNotRoud67() {
        int result = roundGrade( 67 );
        int expected = 67;
        assert ( result == expected ) : "Result:" + result +" | Expected:" + expected;
    }

    public static int[] gradingStudents(int[] grades) {
        int gradesLen = grades.length;
        for ( int i = 0; i < gradesLen; i++ ) {
            grades[i] = roundGrade( grades[i] );
        }

        return grades;
    }

    public static int roundGrade( int grade ) {
        if ( grade < 38 ) return grade;

        else if (  grade % 5 >= 3 &&  grade % 5 != 0 ) grade += 5 - (grade % 5);

        return grade;
    }

}
