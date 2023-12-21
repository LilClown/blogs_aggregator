package dev.simpleapp.demo.user.tweet.usecase.impl;

import dev.simpleapp.demo.common.exception.TwitterException;
import dev.simpleapp.demo.user.profile.api.service.CurrentUserProfileApiService;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.service.TweetService;
import dev.simpleapp.demo.user.tweet.usecase.TweetDeleteUseCase;
import org.springframework.stereotype.Component;

@Component
public class TweetDeleteUseCaseFacade implements TweetDeleteUseCase {

    private final TweetService tweetService;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public TweetDeleteUseCaseFacade(TweetService tweetService,
                                    CurrentUserProfileApiService currentUserProfileApiService) {
        this.tweetService = tweetService;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public void deleteTweet(long tweetId) {
        UserProfile actor = this.currentUserProfileApiService
                .currentUserProfile();

        UserProfile owner = this.tweetService
                .findTweetById(tweetId)
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не существует", tweetId);
                    return new TwitterException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String.format(
                    "Удаление твита с id = %d запрещено. Пользователь %s не является его владельцем",
                    tweetId,
                    actor.getNickname()
            );
            throw new TwitterException(errorMessage);
        }
        this.tweetService.deleteTweet(tweetId);
    }
}
