package dev.simpleapp.demo.user.tweet.mapper;

import dev.simpleapp.demo.common.mapper.Mapper;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.web.model.TweetEditRequest;

public interface TweetEditRequestToTweetMapper extends Mapper<Tweet, TweetEditRequest> {
}
