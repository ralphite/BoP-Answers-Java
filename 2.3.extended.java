//bop 2.3.extended

import java.util.HashMap;

class User {
    int id;
}
class Post {
    User author;
    User[] commenters;
}

public class Solution {
    //method 1 - use map if number of ids is small.
    //time complexity is still O(n)
    public static int[] topThree(int[] ids) {
        HashMap<Integer, Integer> map 
            = new HashMap<Integer, Integer>();
        for(int id : ids) {
            if(!map.containsKey(id)) {
                map.put(id, 1);
            } else {
                map.put(id, map.get(id) + 1);
            }
        }
        int r[] = new int[3];
        int k;
        k = getTop(map);
        r[0] = map.get(k);
        map.remove(k);
        k = getTop(map);
        r[1] = map.get(k);
        map.remove(k);
        k = getTop(map);
        r[2] = map.get(k);
        map.remove(k);
        return r;
    }
    private static int getTop(HashMap<Integer, Integer> map) {
        int max = 0;
        int maxk = -1;
        for(int k : map.keySet()) {
            int v = map.get(k);
            if(v > max) {
                max = v;
                maxk = k;
            }
        }
        return maxk;
    }
}
