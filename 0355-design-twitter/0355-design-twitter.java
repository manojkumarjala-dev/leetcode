class Twitter {
    private static int time = 0;
    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<int[]>> tweets;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = new HashSet<>(follows.getOrDefault(userId, new HashSet<>()));
        following.add(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max heap by timestamp

        for (int u : following) {
            List<int[]> ts = tweets.getOrDefault(u, new ArrayList<>());
            for (int j = ts.size() - 1; j >= 0 && j >= ts.size() - 10; j--) {
                pq.offer(ts.get(j));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll()[1]);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
