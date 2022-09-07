package hackerrank;

//import com.sun.jdi.Value;
//import edu.princeton.cs.algs4.In;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Probelm: https://www.hackerrank.com/challenges/climbing-the-leaderboard/
 *
 * Alternate solution for reference: https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Implementation/Climbing%20the%20Leaderboard/Solution.java
 *
 * There are 3 solutions. The ones with HashMap implementation
 * was giving timeout.
 *
 * anotherVersion() is from thirdparty.
 *
 * There might be optimization for checking for duplicate
 * marks in Leaderboard and skip it.
 */

public class ClimbingTheLeaderboard {

    public static void main(String args[]) {
//        anotherVersion();
        //Test case 2
//        int[] scores = {100, 100, 50, 40, 40, 20, 10};//
//        int[] alice = {5, 25, 50, 120};//
        // Expected: 6 4 2 1

//        Test Case 1:
        int[] scores = {100, 90, 90, 80, 75, 60};
        int[] alice = {50, 65, 77, 90, 102};
        int[] expected = {6, 5, 4, 2, 1};

        //Modified
//        int[] scores = {100, 90, 90, 80, 75, 75, 57, 56}; // Ranks 1- 7
//        int[] alice = {0, 0, 0, 90, 97, 102};
//        int[] expected = {7, 7, 7, 2, 2, 1};

        //Test 2
//        int[] scores = {997,981,957,933,930,927,926,920,916,896,887,874,863,863,858,847,815,809,803,794,789,785,783,778,764,755,751,740,737,730,691,677,652,650,587,585,583,568,546,541,540,538,531,527,506,493,457,435,430,427,422,422,414,404,400,394,387,384,374,371,369,369,368,365,363,337,336,328,325,316,314,306,282,277,230,227,212,199,179,173,171,168,136,125,124,95,92,88,85,70,68,61,60,59,44,43,28,23,13,12};
//        int[] alice = {12,20,30,32,35,37,63,72,83,85,96,98,98,118,122,125,129,132,140,144,150,164,184,191,194,198,200,220,228,229,229,236,238,246,259,271,276,281,283,287,300,302,306,307,312,318,321,325,341,341,341,344,349,351,354,356,366,369,370,379,380,380,396,405,408,417,423,429,433,435,438,441,442,444,445,445,452,453,465,466,467,468,469,471,475,482,489,491,492,493,498,500,501,504,506,508,523,529,530,539,543,551,552,556,568,569,571,587,591,601,602,606,607,612,614,619,620,623,625,625,627,638,645,653,661,662,669,670,676,684,689,690,709,709,710,716,724,726,730,731,733,737,744,744,747,757,764,765,765,772,773,774,777,787,794,796,797,802,805,811,814,819,819,829,830,841,842,847,857,857,859,860,866,872,879,882,895,900,900,903,905,915,918,918,922,925,927,928,929,931,934,937,955,960,966,974,982,988,996,996};
//        int[] expected = {97,96,94,94,94,94,89,87,87,86,83,83,83,83,83,81,81,81,80,80,80,80,76,76,76,76,75,74,73,73,73,72,72,72,72,72,72,71,70,70,70,70,69,69,69,67,67,66,63,63,63,63,63,63,63,63,61,59,59,57,57,57,54,52,52,51,50,49,48,47,47,47,47,47,47,47,47,47,46,46,46,46,46,46,46,46,46,46,46,45,45,45,45,45,44,44,44,43,43,41,39,38,38,38,37,37,37,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,32,32,32,32,32,32,31,31,31,30,30,30,30,30,30,29,29,29,28,27,27,27,25,24,24,24,24,24,24,24,21,19,19,19,19,18,17,17,16,16,16,16,16,16,15,15,15,14,14,13,13,12,12,11,10,10,10,10,10,9,9,8,8,6,6,6,5,4,4,4,3,3,3,2,2,2,2};


        int[] aliceReturnedMarks = climbingLeaderboard(scores, alice);
//
//        for (int i = 0; i < aliceReturnedMarks.length; i++ ) {
////            System.out.println("Index: " + i);
//            System.out.print(" " + aliceReturnedMarks[i]);
//        }

        //check
        for (int i = 0; i < expected.length; i++ ) {

            if( aliceReturnedMarks[i] != expected[i] ) {
                System.out.println("Index: " + i);
                System.out.println("Alice Mark: " + alice[i]);
                System.out.println("Returned: " + aliceReturnedMarks[i]);
                System.out.println("Expected: " + expected[i]);
            }
        }

    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

//        HashMap<Integer, Integer> rankSystem = new HashMap<>();

        int[] rankSystem = new int[scores.length];
        rankSystem = createRankSystemOptimized(scores, rankSystem);
        return createAliceExamRanksOptimized(scores, rankSystem, alice);
    }

    static int[] createRankSystemOptimized(int[] scores, int[] rankSystem) {

        int rank = 1;
        rankSystem[0] = rank;
        int scoresLen = scores.length - 1;

       for ( int i = 0; i < scoresLen; i++ ){

           if ( scores[i + 1] == scores[i] ) {
               rankSystem[i + 1] = rank;
           }

           if ( scores[i + 1] < scores[i] ) {
               rankSystem[i + 1] = ++rank;
           }
       }
        return rankSystem;
    }

    static int[] createAliceExamRanksOptimized(int[] scores, int[] rankSystem, int[] aliceScores) {

        int ranksLen = rankSystem.length - 1;
        int lenOfAliceScores = 0;
        int[] examsRanksOfAlice = new int[aliceScores.length];

        //iterate through alice scores
        while ( lenOfAliceScores < aliceScores.length  ) {
            int aliceScore = aliceScores[lenOfAliceScores];

            //iterate through ranks to compare
            //while ( numOfRanks >= 1 ) { // this will loop over everything so need a forloop

            while ( ranksLen >= 0 ) {

                if ( aliceScore == scores[ranksLen] ) {
                    examsRanksOfAlice[lenOfAliceScores] = rankSystem[ranksLen];
                    break;
                }

                if ( aliceScore < scores[ranksLen] ) {

                    // This condition is for if the first mark of Alice is
                    // less than the least in the leadersboard. So the rank
                    //  Alice will be lesser thank the last by 1.
                    if ( ranksLen + 1 == rankSystem.length) {
                        examsRanksOfAlice[lenOfAliceScores] = rankSystem[ranksLen] + 1;

                    } else {
                        examsRanksOfAlice[lenOfAliceScores] = rankSystem[ranksLen + 1];
                    }
                    break;

                } else {

                    if (ranksLen == 0) {
                        examsRanksOfAlice[lenOfAliceScores] = 1;
                        break;
                    }
                    ranksLen--;
                }
            }

            lenOfAliceScores++;
        }

        return examsRanksOfAlice;
    }

    static HashMap<Integer, Integer> createRankSystem(int[] scores) {

        int position = 1;
        int i = 0;
        HashMap<Integer, Integer> rankSystem = new HashMap<>();

        while ( i <= scores.length - 1 ) {

            if ( !rankSystem.containsValue(scores[i]) ) {
                rankSystem.put(position, scores[i]);
//                System.out.println( rankSystem.get(position));
                position++;
            }
            i++;
        }

//        rankSystem.forEach(
//                (k,v) ->  System.out.println(k + " " + v)
//        );

        return rankSystem;
    }

    static int[] createAliceExamRanks(HashMap<Integer, Integer> rankSystem, int[] aliceScores) {

        int numOfRanks = rankSystem.size();
        int lenOfAliceScores = 0;
        int[] examsRanksOfAlice = new int[aliceScores.length];
        int ranks = numOfRanks;

        //iterate through alice scores
        while ( lenOfAliceScores < aliceScores.length  ) {
            int aliceScore = aliceScores[lenOfAliceScores];

            //iterate through ranks to compare
            //while ( numOfRanks >= 1 ) { // this will loop over everything so need a forloop
            while ( ranks > 0 ) {

                if ( aliceScore == rankSystem.get(ranks) ) {
                    examsRanksOfAlice[lenOfAliceScores] = ranks;
                    break;
                }

                if ( aliceScore < rankSystem.get(ranks) ) {
                    examsRanksOfAlice[lenOfAliceScores] = ranks + 1;
                    break;
                } else {
                    if (ranks == 1) {examsRanksOfAlice[lenOfAliceScores] = 1; break;}
                    ranks--;
                }
            }

            lenOfAliceScores++;
        }

        return examsRanksOfAlice;
    }



    static void anotherVersion() {
        int[] scores = {100, 90, 90, 80, 75, 60};
        int[] alice = {50, 65, 77, 90, 102};

        int[] ranks = new int[scores.length]; //The dense ranking of the scores

        //Initialize dense ranking and scores
        for(int i=0, rank=1; i < scores.length; i++){
            if(i > 0 && scores[i-1] != scores[i])
                rank++;
            ranks[i] = rank;

//            System.out.println(ranks[i]);
        }


        //Interate over Alice's level scores
        //int level = 0;
        int aliceRank = ranks[ranks.length-1] + 1; //Set it to worst rank+1
        int leaderboardIndex = scores.length - 1;
        int prevScore = -1; //Last score we saw
        int[] aliceRanksArr = new int[alice.length];
        int aliceRankScore = 0;

        for(int aliceScores=0; aliceScores < alice.length; aliceScores++)
        {
            int levelScore = alice[aliceScores];

            //We iterate 1 past the front of the array incase we are greater than the best score
            for(int i = leaderboardIndex; i >= -1; i--)
            {
                if(i < 0 || scores[i] > levelScore)
                {
                    System.out.println(aliceRank);
                    aliceRanksArr[aliceRankScore++] = aliceRank;
                    break;
                }
                else if(scores[i] < levelScore)
                {
                    if(scores[i] != prevScore)//We have went up a ranking
                    {
                        aliceRank--;
                    }
                    leaderboardIndex--;
                }
                else//scores[i] == alice[level]
                {
                    leaderboardIndex--;
                    aliceRank = ranks[i];
                }
                prevScore = scores[i];
            }
        }
//        aliceRanksArr

    }

}
