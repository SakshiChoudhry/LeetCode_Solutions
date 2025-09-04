import java.util.*;

class Tweet
{
    int tweetId;
    int time;
    Tweet next;
    Tweet(int tweetId,int time)
    {
        this.tweetId=tweetId;
        this.time=time;
        this.next=null;
    }
}
class Twitter {
    static int timestamp=0;
    public Map<Integer, Set<Integer>> followList;
    public Map<Integer,Tweet> feed;


    public Twitter() {
        followList=new HashMap<>();
        feed=new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tw=new Tweet(tweetId,timestamp++);
        tw.next=feed.get(userId);
        feed.put(userId,tw);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Tweet> p=new PriorityQueue<>((a,b)->b.time-a.time);
        if(feed.containsKey(userId))
        {
            //self ki latest tweet
            p.offer(feed.get(userId));
        }
        if(followList.containsKey(userId))
        {
            for(int followee:followList.get(userId))
            {
                if(feed.containsKey(followee))
                {
                    p.offer(feed.get(followee));
                }
            }
        }
        while(!p.isEmpty()&& res.size()<10)
        {
            Tweet t=p.poll();
            res.add(t.tweetId);
            if(t.next!=null)

            {
                p.offer(t.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
        {
            return;
        }
        if(!followList.containsKey(followerId))
        {
            followList.put(followerId,new HashSet<>());
        }
        followList.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followList.containsKey(followerId))
        {
            followList.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */