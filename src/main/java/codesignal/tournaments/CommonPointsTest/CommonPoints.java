package codesignal.tournaments.CommonPointsTest;

public class CommonPoints {
    public int commonPoints(int l1, int r1, int l2, int r2) {
        int min = l2 > l1 ? l2 : l1;
        int max = r2 > r1 ? r1 : r2;

        if ( max == min || max < min ) return 0;

        return ( max - min - 1 );
    }
}
