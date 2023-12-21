package dev.simpleapp.demo.user.tweet.mapper.impl;

import dev.simpleapp.demo.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import dev.simpleapp.demo.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {
    @Override
    public TweetResponse map(Tweet model) {
        return new TweetResponse(
                model.getId(),
                model.getMessage(),
                model.getCreatedTimestamp(),
                model.getModifiedTimestamp()
        );
    }
}
