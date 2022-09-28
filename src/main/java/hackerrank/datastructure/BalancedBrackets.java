package hackerrank.datastructure;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        validTestCase1();
    }

    static void validTestCase1() {
        String s = "{[()]}";
        String expected = "YES";
        String result = isBalanced(s);
//        String result = isBalancedThirdParty(s);
        assert (result.equals(expected)) : "Result:" + result +" | Expected:" + expected;
    }

    static String isBalanced(String s) {
        int sCharArrayLen= s.length() - 1;

        Stack<Character> sStack = new Stack<>();
        HashMap<Character, Character> paranthesisMap = new HashMap<>();
        paranthesisMap.put('{', '}');
        paranthesisMap.put('(', ')');
        paranthesisMap.put('[', ']');

        while ( sCharArrayLen >= 0 ) {
            char paraenthesisChar = s.charAt(sCharArrayLen);

            if (( paraenthesisChar == ']' )
                    || ( paraenthesisChar == ')' )
                    || ( paraenthesisChar == '}' ) )
                sStack.push(paraenthesisChar);

            else {
                char poppedChar = '~';
                // when this condition was not checked
                // the first three test cases before
                // submission i.e. 18, 19, 20 ONLY
                // passes. And all test cases while
                // submission failed
                if (!sStack.empty()) poppedChar = sStack.pop();

                if ( !paranthesisMap.get( paraenthesisChar ).equals(poppedChar) ) return "NO";
            }
            sCharArrayLen--;
        }

        //return "YES"; //previous
        // when this is condition is not checked,
        // test case 9 fails.
        return sStack.isEmpty() ? "YES" : "NO";
    }

    /**
     * This solution is for reference and it
     * also passes all test cases.
     *
     * @param s
     * @return
     */
    static String isBalancedThirdParty(String s) {
            Stack<Character> stack = new Stack<>();
            char upperElement = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty()) {
                    upperElement = stack.peek();
                }
                stack.push(s.charAt(i));
                if (!stack.isEmpty() && stack.size() > 1) {
                    if ((upperElement == '[' && stack.peek() == ']') ||
                            (upperElement == '{' && stack.peek() == '}') ||
                            (upperElement == '(' && stack.peek() == ')')) {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
            return stack.isEmpty() ? "YES" : "NO";
    }
}
