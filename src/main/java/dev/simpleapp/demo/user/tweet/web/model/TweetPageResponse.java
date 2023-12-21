package dev.simpleapp.demo.user.tweet.web.model;

import java.util.Collection;

public record TweetPageResponse(
        long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<TweetResponse> tweets
) {
}
