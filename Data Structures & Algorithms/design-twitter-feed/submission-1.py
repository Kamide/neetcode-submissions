from typing import NamedTuple


class Tweet(NamedTuple):
    author: int
    id: int
    timestamp: int


class Follow(NamedTuple):
    follower: int
    followee: int


def news_feed(
    tweets: tuple[Tweet, ...],
    follows: frozenset[Follow],
    user_id: int,
    limit: int
) -> tuple[int, ...]:
    authors = frozenset(
        {user_id} | {
            follow.followee
            for follow in follows
            if follow.follower == user_id
        }
    )

    feed = sorted(
        (
            tweet
            for tweet in tweets
            if tweet.author in authors
        ),
        key=lambda tweet: tweet.timestamp,
        reverse=True
    )

    return tuple(
        tweet.id
        for tweet in feed[:limit]
    )


class Twitter:
    def __init__(self):
        self.timestamp = 0
        self.tweets: tuple[Tweet, ...] = ()
        self.follows: frozenset[Follow] = frozenset()

    def postTweet(self, user_id: int, tweet_id: int) -> None:
        self.timestamp += 1
        self.tweets += (
            Tweet(
                user_id,
                tweet_id,
                self.timestamp
            ),
        )

    def follow(self, follower_id: int, followee_id: int) -> None:
        self.follows |= {
            Follow(
                follower_id,
                followee_id
            )
        }

    def unfollow(self, follower_id: int, followee_id: int) -> None:
        self.follows -= {
            Follow(
                follower_id,
                followee_id
            )
        }

    def getNewsFeed(self, user_id: int) -> list[int]:
        return list(
            news_feed(
                self.tweets,
                self.follows,
                user_id,
                limit=10
            )
        )
