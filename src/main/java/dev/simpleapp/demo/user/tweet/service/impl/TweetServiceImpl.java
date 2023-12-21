package dev.simpleapp.demo.user.tweet.service.impl;

import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.repository.TweetRepository;
import dev.simpleapp.demo.user.tweet.service.TweetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }

    @Override
    public Optional<Tweet> findTweetById(long tweetId) {
        return this.tweetRepository.findById(tweetId);
    }

    @Override
    public void deleteTweet(long tweetId) {
        this.tweetRepository.deleteById(tweetId);
    }

    @Override
    public Page<Tweet> findAllTweets(UserProfile owner, Pageable pageable) {
        return this.tweetRepository.findAllByUserProfile(owner, pageable);
    }
}
