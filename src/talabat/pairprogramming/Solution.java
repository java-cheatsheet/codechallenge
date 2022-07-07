package talabat.pairprogramming;

import java.util.HashMap;

class Solution {
    int x, y;
    char direction;

    public Solution() {
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
    }

    public String currentPosition() {
        String currD = String.valueOf(this.x) + this.y + this.direction;
        return currD;
    }
}
