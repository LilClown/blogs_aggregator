package dev.simpleapp.demo.user.subscription.mapper.impl;

import dev.simpleapp.demo.user.profile.api.service.CurrentUserProfileApiService;
import dev.simpleapp.demo.user.profile.api.service.UserProfileApiService;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.subscription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.simpleapp.demo.user.subscription.model.Subscription;
import dev.simpleapp.demo.user.subscription.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscribeRequestToSubscriptionMapperImpl implements SubscribeRequestToSubscriptionMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;

    public SubscribeRequestToSubscriptionMapperImpl(CurrentUserProfileApiService currentUserProfileApiService,
                                                    UserProfileApiService userProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.userProfileApiService = userProfileApiService;
    }

    @Override
    public Subscription map(SubscribeRequest subscribeRequest) {

        UserProfile follower = this.currentUserProfileApiService
                .currentUserProfile();

        UserProfile followed = this.userProfileApiService
                .findUserProfileById(subscribeRequest.followedId());

        Subscription subscription = new Subscription();
        subscription.setFollower(follower);
        subscription.setFollowed(followed);

        return subscription;
    }
}
