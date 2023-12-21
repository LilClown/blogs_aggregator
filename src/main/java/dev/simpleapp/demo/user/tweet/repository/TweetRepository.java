package dev.simpleapp.demo.user.tweet.repository;

import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Page<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
