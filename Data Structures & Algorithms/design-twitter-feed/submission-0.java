class Twitter {
    private record UserId(
        int raw
    ) {
    }

    private record TweetId(
        int raw
    ) {
    }

    private record Tweet(
        TweetId id,
        long timestamp
    ) {
    }

    private record Candidate(
        UserId author,
        Tweet tweet,
        int index
    ) {
    }

    private static class Clock {
        long timestamp = 0;

        long now() {
            timestamp += 1;
            return timestamp;
        }
    }

    private static final int FEED_SIZE = 10;

    private final Clock clock = new Clock();
    private final Map<UserId, List<Tweet>> tweets = new HashMap<>();
    private final Map<UserId, Set<UserId>> follows = new HashMap<>();

    public void postTweet(final int userId, final int tweetId) {
        tweets
            .computeIfAbsent(
                new UserId(userId),
                unused -> new ArrayList<>()
            )
            .add(
                new Tweet(
                    new TweetId(tweetId),
                    clock.now()
                )
            );
    }

    public void follow(final int followerId, final int followeeId) {
        follows
            .computeIfAbsent(
                new UserId(followerId),
                unused -> new HashSet<>()
            )
            .add(new UserId(followeeId));
    }

    public void unfollow(final int followerId, final int followeeId) {
        follows.computeIfPresent(
            new UserId(followerId),
            (unused, set) -> {
                set.remove(new UserId(followeeId));
                return set.isEmpty() ? null : set;
            }
        );
    }

    public List<Integer> getNewsFeed(final int userId) {
        final var user = new UserId(userId);
        final var authors = new HashSet<>(
            follows.getOrDefault(user, Set.of())
        );

        authors.add(user);

        final var candidates = new PriorityQueue<>(
            Comparator
                .comparingLong(
                    (Candidate candidate) ->
                        candidate.tweet().timestamp()
                )
                .reversed()
        );

        for (final var author : authors) {
            final var timeline = tweets.get(author);

            if (timeline == null || timeline.isEmpty()) {
                continue;
            }

            final var index = timeline.size() - 1;

            candidates.offer(
                new Candidate(
                    author,
                    timeline.get(index),
                    index
                )
            );
        }

        final var feed = new ArrayList<Integer>(FEED_SIZE);

        while (!candidates.isEmpty() && feed.size() < FEED_SIZE) {
            final var candidate = candidates.poll();

            feed.add(candidate.tweet().id().raw());

            final var previousIndex = candidate.index() - 1;

            if (previousIndex >= 0) {
                final var timeline = tweets.get(candidate.author());

                candidates.offer(
                    new Candidate(
                        candidate.author(),
                        timeline.get(previousIndex),
                        previousIndex
                    )
                );
            }
        }

        return feed;
    }
}
