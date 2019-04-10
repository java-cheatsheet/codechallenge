package hackerrank.DynamicProgramming;

import java.util.Arrays;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/equal/problem
 *
 * Solution:
 * http://edisonwang.me/algorithms-dynamic-programming-equal/
 *
 * Similar problem solution:
 * https://codereview.stackexchange.com/questions/136664/hackerrank-equal-stacks
 */
public class Equal {

    public static void main(String args[]) {
        validTestFor5();
        failedTestCase13WhenJLessThan2();
    }

    /**
     * Test case 13.
     *
     * Problem: 2 5 5 5 5 5
     * Solution: 6
     *
     * This test case fails when the value
     * of loop j was less than 2,
     *      for (int j = 0; j < 2; j++ )
     *
     */
    public static void failedTestCase13WhenJLessThan2() {
        System.out.println("failedTestCase13WhenJLessThan2");
        int[] arr = {2, 5, 5, 5, 5, 5};
        int expected = 6;
        ThirdpartySolution sol = new ThirdpartySolution();
        int result = sol.equal(arr);

        assert (result == expected) : "testOddData - Result:" + result + " | Expected:" + expected;
    }

    public static void validTestFor5() {
        System.out.println("validTestFor5");
        int[] arr = {2, 2, 3, 7};
        int expected = 2;
        ThirdpartySolution sol = new ThirdpartySolution();
        int result = sol.equal(arr);

        assert (result == expected) : "testOddData - Result:" + result + " | Expected:" + expected;
    }
}

/**
 * Source: http://edisonwang.me/algorithms-dynamic-programming-equal/
 *
 * The solution is modified to from
 * original while take the sum to reduce
 * the number of for-loop.
 *
 * The solution takes a Greedy approach.
 *
 */
class ThirdpartySolution {

    static boolean DBG = true;

    static int equal(int[] arr){
        Arrays.sort(arr);
        int min = arr[0];
        int arrLen = arr.length;
        int finalSolution = -1;
        int subFinal;
        int delta;
        int[][] results = new int[arrLen][3];

        for (int j = 0; j < 3; j++){
            subFinal = 0;

            for (int i = 0; i < arrLen; i++){
                results[i][j] = 0;

                //main logic
                delta = ( arr[i] - min ) + j;

                //greedy approach
                while ( true ) {
                    if( delta >=5 ) {
                        delta -= 5;
                    }else if( delta >=2 ) {
                        delta -= 2;
                    }else if ( delta >= 1 ) {
                        delta -= 1;
                    } else {
                        break;
                    }
                    results[i][j]++;
                }

                subFinal += results[i][j];

                if(DBG) System.out.format(" arr[%d] | results[%d][%d] = %d  \n", arr[i], j, i, results[i][j]);
            }

            if(DBG) System.out.println(subFinal);

            if( finalSolution > subFinal || finalSolution < 0 ) finalSolution = subFinal;
        }

        return finalSolution;
    }
}


/**
 * This was the initial solution I
 * came up with but fails as it is
 * brute force due to time out even
 * at Run Code in hackerrank.
 *
 * Test Case 0
 * Problem set:
 * 110
 * 53 361 188 665 786 898 447 562 272 123 229 629 670 848 994 54 822 46 208 17 449 302 466 832 931 778 156 39 31 777 749 436 138 289 453 276 539 901 839 811 24 420 440 46 269 786 101 443 832 661 460 281 964 278 465 247 408 622 638 440 751 739 876 889 380 330 517 919 583 356 83 959 129 875 5 750 662 106 193 494 120 653 128 84 283 593 683 44 567 321 484 318 412 712 559 792 394 77 711 977 785 146 936 914 22 942 664 36 400 857
 * 82
 * 520 862 10 956 498 956 991 542 523 664 378 194 76 90 753 868 837 830 932 814 616 78 103 882 452 397 899 488 149 108 723 22 323 733 330 821 41 322 715 917 986 93 111 63 535 864 931 372 47 215 539 15 294 642 897 98 391 796 939 540 257 662 562 580 747 893 401 789 215 468 58 553 561 169 616 448 385 900 173 432 115 712
 * 199
 * 761 706 697 212 97 845 151 637 102 165 200 34 912 445 435 53 12 255 111 565 816 632 534 617 18 786 790 802 253 502 602 15 208 651 227 305 848 730 294 303 895 846 337 159 291 125 565 655 380 28 221 549 13 107 166 31 245 308 185 498 810 139 865 370 790 444 27 639 174 321 294 421 168 631 933 811 756 498 467 137 878 40 686 891 499 204 274 744 512 460 242 674 599 108 396 742 552 423 733 79 96 27 852 264 658 785 76 415 635 895 904 514 935 942 757 434 498 32 178 10 844 772 36 795 880 432 537 785 855 270 864 951 649 716 568 308 854 996 75 489 891 331 355 178 273 113 612 771 497 142 133 341 914 521 488 147 953 26 284 160 648 500 463 298 568 31 958 422 379 385 264 622 716 619 800 341 732 764 464 581 258 949 922 173 470 411 672 423 789 956 583 789 808 46 439 376 430 749 151
 * 161
 * 134 415 784 202 34 584 543 119 701 7 700 959 956 975 484 426 738 508 201 527 816 136 668 624 535 108 1 965 857 152 478 344 567 262 546 953 199 90 72 900 449 773 211 758 100 696 536 838 204 738 717 21 874 385 997 761 845 998 78 703 502 557 47 421 819 945 375 370 35 799 622 837 924 834 595 24 882 483 862 438 221 931 811 448 317 809 561 162 159 640 217 662 197 616 435 368 562 162 739 949 962 713 786 238 899 733 263 781 217 477 220 790 409 383 590 726 192 152 240 352 792 458 366 341 74 801 709 988 964 800 938 278 514 76 516 413 810 131 547 379 609 119 169 370 502 112 448 695 264 688 399 408 498 765 749 925 918 458 913 234 611
 * 51
 * 512 125 928 381 890 90 512 789 469 473 908 990 195 763 102 643 458 366 684 857 126 534 974 875 459 892 686 373 127 297 576 991 774 856 372 664 946 237 806 767 62 714 758 258 477 860 253 287 579 289 496
 *
 * Solution set:
 * 10605
 * 8198
 * 18762
 * 16931
 * 5104
 *
 */
class BruteForceSolution {
    static int equal( int[] arr) {
        Arrays.sort(arr);
        int lenArr = arr.length - 1;
        int operations = 0;
        int min = arr[0];
        int tempMin = arr[0];

        while ( lenArr >= 0 ) {

            //check if max == min
            //if ( min == arr[lenArr] ) return operations;

            // check what can be substracted from substraction list
            // {5, 2, 1}. Here we also need to check the near by number
            // say { 2,3 } is list, then it is possible to substract 2 from 3
            // but we will only substract 1
            int diffMaxMin = arr[lenArr] - min;

            if( diffMaxMin >= 5 ) {
                tempMin = arr[lenArr] - 5;
                operations++;

            } else if ( diffMaxMin >= 2 ) {
                tempMin = arr[lenArr] - 2;
                operations++;

            } else if ( diffMaxMin >= 1 ) {
                tempMin = arr[lenArr] - 1;
                operations++;
            }

            if ( tempMin < min ) min = tempMin;

            if ( tempMin == min ) {
                lenArr--;
            }

        }

        return operations;
    }
}
