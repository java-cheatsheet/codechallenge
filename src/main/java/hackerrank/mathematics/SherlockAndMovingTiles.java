package hackerrank.mathematics;

import java.math.BigDecimal;
import java.math.MathContext;

public class SherlockAndMovingTiles {

    public static void main(String[] args) {
        int l = 10;
        int s1 = 1;
        int s2 =  2;
        int[] queries = {};//{916782916802, 961358140081};//{50 , 100};

        l =  1000000;
        s1 = 1000004;
        s2 = 1000003;

        movingTilesORIGINAL( l, s1, s2, queries);

    }

    /**
     *

     Considering the absolute value of the difference in velocities. That is the relative velocity.
     Asking for a square of area A is the same thing than asking
     for a square of diagonal sqrt(2 * a) (check it).
     The diagonal of the inner square as a function of time is
     d = L * sqrt(2) - rel_vel * time.
     We have then a linear equation instead of a quadratic one.
    ---------------
     Since distance=speed*time distance travelled by any point on
     tile1 = s1 * t.  similarly, distance travelled by any point on
     tile2  = is s2 * t. At any time t, distance between the corresponding
     points of 2 tiles will be absolute value of( s2*t - s1 *t ).
     Length of the diagonal of a square whose side l is sqrt(2) * l.
     q is the area of square made by the intersection of these tiles.
     Let length of the side of the square made from intersection of tiles is k.
     The diagonal length wil be sqrt(2) * k and that is nothing but difference
     of diagonal length of given square and relative distance between tiles
     sqrt(2) * k = sqrt(2) * l -( abs( s1 - s2 ) * t )
     from value of k,value of q can be interrupted


     * @param l
     * @param s1
     * @param s2
     * @param queries
     * @return
     */
    static double[] movingTiles(int l, int s1, int s2, int[] queries) {
        int n = queries.length;
        double[] result = new double[n];
        MathContext mc = new MathContext(5 );
        BigDecimal sqrta = new BigDecimal(2);
        System.out.println(sqrta.divide(  sqrta ));

        BigDecimal sqrt = new BigDecimal(Math.sqrt(2), mc);

        BigDecimal rel = sqrt.divide( new BigDecimal( Math.abs( s1 - s2 ) ), mc);

        for ( int i=0; i < n; i++) {
            BigDecimal iSqrt = new BigDecimal( Math.sqrt(i), mc);
            BigDecimal minS =  new BigDecimal(l).subtract( iSqrt );
            BigDecimal bigDecimal = rel.divide(minS, mc);
            result[i] = bigDecimal.doubleValue();
        }
        return result;
    }

    static double[] movingTilesORIGINAL(int l, int s1, int s2, int[] queries) {
        int n = queries.length;
        double[] result = new double[n];
        double rel = Math.abs(s1 - s2) / Math.sqrt(2);

        for ( int i=0; i < n; i++ ) {
            result[i] = ( l - Math.sqrt( queries[i] ) ) / rel;

            System.out.println(result[i]);
        }


        return result;

    }

}
