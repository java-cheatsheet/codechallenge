package talabat.route;

import org.junit.Test;
import org.junit.Assert;

class SolutionTest {

    @Test
    void shouldPassWithExample1() {
        Solution solution = new Solution();
        String[][] itineraries = {
                {"USA", "BRA"},
                {"JPN", "CAI"},
                {"BRA", "UAE"},
                {"UAE", "JPN"}
        };
        String expected = "USA, BRA, UAE, JPN, CAI";
        Assert.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample1OneMore() {
        Solution solution = new Solution();
        String[][] itineraries = {
                {"USA", "BRA"},
                {"JPN", "CAI"},
                {"BRA", "UAE"},
                {"UAE", "JPN"},
                {"CAI", "KAT"}
        };
        String expected = "USA, BRA, UAE, JPN, CAI, KAT";
        Assert.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample2() {

        Solution solution = new Solution();
        String[][] itineraries = {
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Winnipeg", "Seattle"}
        };
        String expected = "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle";
        Assert.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample2Suffled() {

        Solution solution = new Solution();
        String[][] itineraries = {
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Winnipeg", "Seattle"}
        };
        String expected = "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle";
        Assert.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithASingleInput() {
        Solution solution = new Solution();
        String[][] itineraries = {
                {"USA", "BRA"}
        };
        String expected = "USA, BRA";
        Assert.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample2AddOne() {

        Solution solution = new Solution();
        String[][] itineraries = {
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Winnipeg", "Seattle"},
                {"Seattle", "Boston"}
        };
        String expected = "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle, Boston";
        Assert.assertEquals(expected, solution.trackRoute(itineraries));
    }
}
