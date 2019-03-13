package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem:
 * import static hackerrank.SherlockAndAnagrams.shouldCount10for4SameChars;
 * You are given an array and you need to find number of tripets of indices (i,j,k)such that the elements at those indices are in geometric progression for a given common ratio r and  i<j<k.
 *
 * Function Description
 * Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given
 * as an integer.
 *
 *
 * https://hr-testcases-us-east-1.s3.amazonaws.com/70878/input03.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1552424343&Signature=Fh6j1gJBkVXzote2%2BpiE7R0mFyc%3D&response-content-type=text%2Fplain
 * Test case 3: 100000 1
 * 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 1237 ...
 * Expected Output: 166661666700000
 *
 *
 * https://hr-testcases-us-east-1.s3.amazonaws.com/70878/input09.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1552490290&Signature=NT%2FM6IDMIVmjSnURf8X0N147cgM%3D&response-content-type=text%2Fplain
 * Test case 9: 100000 4
 * 1 149594968 609658275 439460718 279358085 930661663 198604725 322272364 803866367 88833983 505313361 378400928 558235432 172976956 89666581 922700745 624378156 52940381 912064149 490213568 898176652 159621309 568290869 51316505 389310802 779172842 332888807 740850128 857941500 686642422 82661415 28441004 836237390 692319689 320418073 968111826 475497704 519022797 290384189 279364070 460373131 648213901 657764998 18608562 821190857 747431578 793825659 298085364 652888310 558406159 640815283 403581313 718027467 61622503 454897817 107338268 840795344 787786623 848188395 551253196 326945397 930849809 432210551 15699138 475685850 605144975 983810963 951183553 124167772 126711503 83063974 437057254 774925403 593345323 308182168 448632611 193293252 102007826 599234326 846181561 660413984 240049609 102279225 230957802 301672111 409693393 338296069 994983807 49996368 39000815 398753354 376941764 822366976 830963904 245157253 150569177 288625230 81484567 101752729 265309353 208196069 37333054 702366607 835637823 630678377 10548774 136786786 823971628 112556599 736021111 522669541 625486934 976070719 477465117 856444735 130259182 887158510 47257155 125242988 937154877 86257969 376512693 166612992 761141296 59992948 411770244 911710472 348618177 493254810 865979552 613927530 701450878 903312606 316294136 389605052 386507334 179359261 526391837 62995313 144432211 262412948 438181205 769919144 91000018 915646322 478880230 73775551 802804831 378653736 51534890 592476059 317428056 428047582 759089050 78569352 488040529 170859293 990279823 836658706 664114102 708775727 450586235 218081331 464604684 619396722 607686382 851112017 798755982 134078219 766623681 943188192 249007518 204804886 565623687 192523887 120451207 44503916 266299438 775772389 275674003 317834327 220764799 593102058 745881909 979853848 671671409 233922437 3229492 514467584 70581142 667343593 75759662 373683728 737941275 540364345 993080449 198144008 243992713 644352782 184738578 10616393 587540973 433746095 67937630 5681011 626269982 40905188 50184926 892569419 816677576 178375280 62920097 37442374 771477338 808802005 869812573 295665098 42724442 873042064 810132681 965821935 392902008 885892342 192022015 130843282 278773038 37618815 328987290 522765750 681971597 513725867 533382143 122028921 799988314 601319772 127709932 278774647 642224960 30411209 23860417 311418887 208786489 86780513 201377613 980263826 895582518 71190185 128445275 790823311 796748601 938577956 609161597 189650608 676986649 801183611 173010242 955759687 691318778 501997531 331041788 225806726 868239749 864423930 347835646 668228062 318260054 328061929 947002708 813001365 358473138 970863124 124420251 419775978 57643637 178314215 252556155 805742506 102020752 381001429 596565816..
 * Expected Output: 0
 *
 */
public class CountTriplets {

    public static void main(String args[]) {
//        whenR1();
        shouldCount4();

//        166661666700000L 134730530881L 108917163L

//        long sum = 88049L/1237L; // = 71;
//
//        for (long k = 1; k < 100000; k++) {
//            sum = sum + 1237;
//        }

//        System.out.println(sum);


    }

    public static void whenR1() {
        long[] input = {5, 5, 5, 5, 5};
        List<Long> arr = Arrays.stream(input).boxed().collect(Collectors.toList());

        long result = countTriplets(arr, 1);
        int expected = 3; //012, 013, 124, 134, 245, 345
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldCount4() {
        long[] input = {1, 5, 5, 25, 125};
        List<Long> arr = Arrays.stream(input).boxed().collect(Collectors.toList());

        long result = countTriplets(arr, 5);
        int expected = 4; //012, 013, 124, 134, 245, 345
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldCount6() {
        long[] input = {1, 3, 9, 9, 27, 81};
        List<Long> arr = Arrays.stream(input).boxed().collect(Collectors.toList());

        long result = countTriplets(arr, 3);
        int expected = 6; //012, 013, 124, 134, 245, 345
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static long countTriplets(List<Long>  arr, long r) {
        Map<Long, Long> t2 = new HashMap<>();
        Map<Long, Long> t3 = new HashMap<>();
        long result = 0L;

        for (Long a : arr) {
            result += t3.getOrDefault(a, 0L);

            if (t2.containsKey(a)) {
                t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.get(a));
            }

            t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
        }
        return result;
    }

    /**
     * This solution also failed. And found one passing in the discussion.
     *
     * -----------
     * The sum of the recurrences of the numbers in the pairs give the total
     * pairs that can be formed.
     *
     * For a set of {1,5,5,25,125}, we can calculate by :
     * From 0 power to 2, i.e. 5 Pow 0 to 2, there are one 1, two 5 and one 25; which is 1 * 2 * 1 = 2
     * From power 1 to 3, there are two 5, one 25 and one 125; which is 2 * 1 * 1 = 2
     * Hence, the total set will be 2 + 2 = 4.
     *
     * This assumption seems to be true for other sets as well!
     *
     * Solution:
     * (Assumption) The sequence is in geometric ratio.
     *
     * 1. store the count of the numbers in a hashmap.
     * i.e. From 0th power, 0 index that will be the first and so on..

     * 2. Get the 3 consecutive geometric numbers, and their count values.
     *
     * 3. Multiply the numbers and save it to total sum.
     *
     * 4. Move to next consecutive number.
     *
     * 5. The loop will go for total numbers - 3
     *
     * @param arr
     * @param r
     * @return
     */
    public static long countTripletsX(List<Long>  arr, long r) {
        long[] lArr = arr.stream().mapToLong(l -> l).toArray();
        Map<Long, Integer> map = getFrequencyMapFromArray(lArr);

        map.forEach((k,v) -> System.out.println(k + " : "+ v));

        int sizeOfMap = map.size();
        long sum = 0;

        for ( int i = 0; i < sizeOfMap - 2; i++ ) {
            long firstGeometricalKey = (long)Math.pow((double)r, (double)i);
            long secondGeometricalKey = (long)Math.pow((double)r, (double)i + 1);
            long thirdGeometricalKey = (long)Math.pow((double)r, (double)i + 2);

            System.out.println( i + ":" + firstGeometricalKey + ":" + secondGeometricalKey + ":" + thirdGeometricalKey );

            sum += getSum( map.get(firstGeometricalKey),
                    map.get(secondGeometricalKey),
                    map.get(thirdGeometricalKey) );
        }

        return sum;
    }


    private static long getSum(int firstValue, int secondValue, int thirdValue) {
        System.out.println( firstValue + ":" + secondValue + ":" + thirdValue );
        return ( firstValue * secondValue * thirdValue );
    }

    private static Map<Long, Integer> getFrequencyMapFromArray(long[] arr) {

        Map<Long, Integer> map = new HashMap<>();

        for(long key : arr){
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key, 1);
        }
        return map;
    }


}


    /**
     * Previous Concept
     * @param arr
     * @param r
     * @return
     *
    public static long PcountTriplets(List<Long>  arr, long r) {
        // tripletsCount
        // first loop to go through all the numbers
        // get the power of the number in the from the first loop.
        // second loop to check the if geometric progression
        // find the +1 power and then the +2 power

        int arrSize = arr.size() - 1;
        int count = 0;
        Long maxNum = Collections.max(arr);

        for ( int i = 0; i < arrSize; i++ ) {
            double firstGeometricalValue = Math.pow((double)r, (double)i);
            double secondGeometricalValue = Math.pow((double)r, (double)i + 1);
            double thirdGeometricalValue = Math.pow((double)r, (double)i + 2);

            System.out.println( i + ":" + firstGeometricalValue + ":" + secondGeometricalValue + ":" + thirdGeometricalValue );

            for ( int j = i+1; j < arrSize; j++ ) {

                if ( (long)secondGeometricalValue == (long)arr.get(j) ) {

                    for ( int k = j+1; k < arrSize; k++ ) {

                        if ( (long)thirdGeometricalValue == (long)arr.get(k) ) {
                            System.out.println( i + ":" + firstGeometricalValue + ":" + secondGeometricalValue + ":" + thirdGeometricalValue );
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);

        return count;
    }
    */