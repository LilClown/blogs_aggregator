package dev.simpleapp.demo.user.tweet.usecase;

import dev.simpleapp.demo.user.tweet.web.model.TweetAddRequest;
import dev.simpleapp.demo.user.tweet.web.model.TweetResponse;

public interface TweetAddUseCase {
    TweetResponse addTweet(TweetAddRequest addRequest);
}
