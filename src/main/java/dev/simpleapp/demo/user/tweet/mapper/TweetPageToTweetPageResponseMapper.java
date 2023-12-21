package dev.simpleapp.demo.user.tweet.mapper;

import dev.simpleapp.demo.common.mapper.Mapper;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;

public interface TweetPageToTweetPageResponseMapper
        extends Mapper<TweetPageResponse, Page<Tweet>> {
}
