package dev.simpleapp.demo.user.tweet.usecase.impl;

import dev.simpleapp.demo.user.profile.api.service.CurrentUserProfileApiService;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.tweet.mapper.TweetPageToTweetPageResponseMapper;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.service.TweetService;
import dev.simpleapp.demo.user.tweet.usecase.TweetFindUseCase;
import dev.simpleapp.demo.user.tweet.web.model.TweetFindRequest;
import dev.simpleapp.demo.user.tweet.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class TweetFindUseCaseFacade implements TweetFindUseCase {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    private final TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper;

    public TweetFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                  TweetService tweetService,
                                  TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.tweetService = tweetService;
        this.tweetPageToTweetPageResponseMapper = tweetPageToTweetPageResponseMapper;
    }

    @Override
    public TweetPageResponse findTweets(TweetFindRequest findRequest) {
        UserProfile owner = this.currentUserProfileApiService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, "createdTimestamp");

        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Page<Tweet> pageableTweetResult = this.tweetService.findAllTweets(owner, pageable);

        return this.tweetPageToTweetPageResponseMapper.map(pageableTweetResult);
    }
}
