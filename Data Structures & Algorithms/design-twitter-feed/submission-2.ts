type UserId = number;
type TweetId = number;
type Tweet = {
    id: TweetId;
    timestamp: number;
};

class Twitter {
    timestamp = 0;
    tweets: Record<UserId, Tweet[]> = {};
    follows: Record<UserId, Set<UserId>> = {};

    postTweet(userId: UserId, tweetId: TweetId): void {
        (this.tweets[userId] ??= []).push({
            id: tweetId,
            timestamp: this.timestamp++,
        });
    }

    follow(followerId: UserId, followeeId: UserId): void {
        (this.follows[followerId] ??= new Set()).add(followeeId);
    }

    unfollow(followerId: UserId, followeeId: UserId): void {
        this.follows[followerId]?.delete(followeeId);
    }

    getNewsFeed(userId: UserId): TweetId[] {
        return [...(this.follows[userId] ?? []), userId]
            .flatMap((id) => this.tweets[id] ?? [])
            .sort((a, b) => b.timestamp - a.timestamp)
            .slice(0, 10)
            .map((tweet) => tweet.id);
    }
}
