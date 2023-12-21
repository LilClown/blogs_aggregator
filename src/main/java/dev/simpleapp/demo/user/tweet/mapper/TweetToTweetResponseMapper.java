package dev.simpleapp.demo.user.tweet.mapper;

import dev.simpleapp.demo.common.mapper.Mapper;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.web.model.TweetResponse;

public interface TweetToTweetResponseMapper extends Mapper<TweetResponse, Tweet> {
}
