package dev.simpleapp.demo.user.tweet.usecase;

import dev.simpleapp.demo.user.tweet.web.model.TweetEditRequest;
import dev.simpleapp.demo.user.tweet.web.model.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest editRequest);
}
