package dev.simpleapp.demo.user.subscription.repository;

import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByFollowerAndFollowed(UserProfile follower, UserProfile followed);

    Optional<Subscription> findByFollowerAndFollowed(UserProfile follower, UserProfile followed);
}
