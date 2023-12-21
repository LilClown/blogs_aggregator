package dev.simpleapp.demo.user.tweet.usecase;

import dev.simpleapp.demo.user.tweet.web.model.TweetFindRequest;
import dev.simpleapp.demo.user.tweet.web.model.TweetPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TweetFindUseCase {
    TweetPageResponse findTweets(@Valid TweetFindRequest findRequest);
}
