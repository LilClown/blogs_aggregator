package dev.simpleapp.demo.user.tweet.usecase.impl;

import dev.simpleapp.demo.user.tweet.mapper.TweetAddRequestToTweetMapper;
import dev.simpleapp.demo.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.service.TweetService;
import dev.simpleapp.demo.user.tweet.usecase.TweetAddUseCase;
import dev.simpleapp.demo.user.tweet.web.model.TweetAddRequest;
import dev.simpleapp.demo.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetAddUseCaseFacade implements TweetAddUseCase {

    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    public TweetAddUseCaseFacade(TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper,
                                 TweetToTweetResponseMapper tweetToTweetResponseMapper,
                                 TweetService tweetService) {
        this.tweetAddRequestToTweetMapper = tweetAddRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.tweetService = tweetService;
    }

    @Override
    public TweetResponse addTweet(TweetAddRequest addRequest) {
        Tweet mappedTweet = this.tweetAddRequestToTweetMapper.map(addRequest);
        Tweet createdTweet = this.tweetService.createTweet(mappedTweet);
        return this.tweetToTweetResponseMapper.map(createdTweet);
    }
}
