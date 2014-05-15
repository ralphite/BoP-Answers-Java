//bop 2.3

import java.util.HashSet;

class User {
    int id;
}
class Post {
    User author;
    User[] commenters;
}

public class Solution {
    //method 1 - use two sets
    //depending on the structure of posts, time complexity can be much smaller than O(n)
    public static int findMostActive(Post[] posts) {
        if(posts.length==0) return -1;
        HashSet<User> freq = new HashSet<User>();
        freq.add(posts[0].author);
        for(User u : posts[0].commenters) {
            freq.add(u);
        }
        for(int i = 1; i < posts.length; i++) {
            HashSet<User> curr = new HashSet<User>();
            curr.add(posts[0].author);
            for(User u : posts[i].commenters) {
                curr.add(u);
            }
            Iterator iter = freq.iterator();
            while(iter.hasNext()) {
                if(!curr.contains(iter.next())) {
                    iter.remove();
                }
            }
            while(freq.size() <= 1) {
                break;
            }
        }
        if(freq.isEmpty()) {
            return -1;
        }
        return ((User)(freq.toArray())[0]).id;
    }

    //method 2 O(n)
    public static int findMostActive(int[] ids) {
        if(ids.length==0) return -1;
        int cnt = 0;
        int curr = 0;
        for(int i = 0; i < ids.length; i++) {
            if(cnt == 0) {
                curr = i;
            }
            if(ids[i] == ids[curr]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return ids[curr];
    }
}
