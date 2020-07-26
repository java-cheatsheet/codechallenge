package hackerrank;

import java.util.List;

class BatteryStatus {
    public static void main(String[] args) {

    }

    public static void basicsList() {
        // charge can not be > 100
        // charge can not be < 0

        List<Integer> a = List.of(25, -30, 70, -10);
        int initialState = 50;
//        int intermediate = 0;
        for (int aI : a) {
            initialState = initialState + aI;

            if (initialState > 100) initialState = 100;
            if (initialState <= 0) initialState = 0;

        }

        System.out.println(initialState);
//        System.out.println(a); // [0, 1, 2, 3, 4, 0, 6, 7, 8, 9]
//        System.out.println(a.get(1));

    }
}

/**`
 * <p>You bought a new gaming laptop and like playing a game on it all day. It requires frequent charging due to high graphics usage. You want to know how much battery will be left after a number of playing and charging events.</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>Write a function that receives <em>n</em>&nbsp;records of the laptop's battery consumption and charging <em>events</em>. An <em>events[i]</em> value represents the number of minutes spent charging the laptop (positive value) or playing a game (negative value) . Every minute, the laptop charges <em>1% </em>or loses <em>1%</em> of its energy. The battery's charge cannot go over <em>100%</em>. Return the laptop's final charge percentage given that the initial charge is <em>50%</em>.<em> </em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>Example</strong></p>
 *
 * <p><em>n = 4</em></p>
 *
 * <p><em>events = [10, -20, 61, -15]</em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>Initially the laptop is charged to 50%. It is plugged in for <em>events[0] = 10</em>&nbsp;minutes and is charged to <em>50 + 10 = 60.</em>&nbsp; A game is played for <i>20 minutes at </i><em>events[1] = -20</em>&nbsp;bringing the charge to <em>40.</em>&nbsp; Charging for another <em>61</em>&nbsp;minutes stops when the charge reaches <em>100</em>, then <em>15</em> minutes of play results in a final charge of <em>85</em>.</p>
 * nbsp;
 * <p>
 * p class="section-title">Function Description</p>
 * <p>
 * p>Complete the function <em>getBattery</em> in the editor below. The function must return an integer.</p>
 * <p>
 * p>&nbsp;</p>
 * <p>
 * p><em>getBattery</em> has the following parameter:</p>
 * <p>
 * p>&nbsp;&nbsp;&nbsp;&nbsp;<em>events[events[0],...events[n-1]]:</em>&nbsp; an array of integers</p>
 * <p>
 * p>&nbsp;</p>
 * <p>
 * p class="section-title">Constraints</p>
 *
 * <ul>
 * <li><em>1 ≤&nbsp;n&nbsp;≤ 10<sup>5</sup></em></li>
 * <li><em>-100 ≤&nbsp;events[i]&nbsp;≤ 100</em></li>
 * <li>The battery charge never goes negative.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <!-- <StartOfInputFormat> DO NOT REMOVE THIS LINE-->
 *
 * <details><summary class="section-title">Input Format For Custom Testing</summary>
 *
 * <div class="collapsable-details">
 * <p>The first line contains an integer, <em>n</em>, denoting the number of elements in <em>events</em>.<br>
 * Each <em>i </em>line of the <em>n</em> subsequent lines (where <em>0 ≤ i &lt; n</em>) contains an integer describing <em>events[i]</em>.</p>
 *
 * <p>&nbsp;</p>
 * </div>
 * </details>
 * <!-- </StartOfInputFormat> DO NOT REMOVE THIS LINE-->
 *
 * <details open="open"><summary class="section-title">Sample Case 0</summary>
 *
 * <div class="collapsable-details">
 * <p class="section-title">Sample Input For Custom Testing</p>
 *
 * <pre>4
 * 25
 * -30
 * 70
 * -10
 * </pre>
 *
 * <p class="section-title">Sample Output</p>
 *
 * <pre>90</pre>
 *
 * <p class="section-title">Explanation</p>
 *
 * <p><em>n = 4</em></p>
 *
 * <p><em>events = [25, -30, 70, 10]</em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>The battery starts at <em>charge = 50%</em>.</p>
 *
 * <p>It is charged for 25 minutes,<em> charge = 75%</em>.</p>
 *
 * <p>Then it is used for 30 minutes, <em>charge = 45%</em>.</p>
 *
 * <p>After that, it is charged for 70 minutes, <em>charge = 100%</em> since it cannot charge over that.</p>
 *
 * <p>Finally, it is used for 10 minutes, <em>charge = 90%</em>.</p>
 *
 * <p>&nbsp;</p>
 * </div>
 * </details>
 *
 * <details><summary class="section-title">Sample Case 1</summary>
 *
 * <div class="collapsable-details">
 * <p class="section-title">Sample Input For Custom Testing</p>
 *
 * <pre>3
 * -10
 * 60
 * 10
 * </pre>
 *
 * <p class="section-title">Sample Output</p>
 *
 * <pre>100</pre>
 *
 * <p class="section-title">Explanation</p>
 *
 * <p><em>n = 3</em></p>
 *
 * <p><em>events = [-10, 60, 10]</em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>The battery starts at 50%.</p>
 *
 * <p>It is used for 10 minutes,<em> charge = 40%</em>.</p>
 *
 * <p>Then it is charged for 60 minutes, <em>charge = 100%</em>.</p>
 *
 * <p>Finally, it is used for 10 minutes, <em>charge = 100%</em>.</p>
 * </div>
 * </details>
 * <p>
 */