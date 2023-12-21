package dev.simpleapp.demo.user.subscription.usecase.impl;

import dev.simpleapp.demo.common.exception.TwitterException;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.subscription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.simpleapp.demo.user.subscription.model.Subscription;
import dev.simpleapp.demo.user.subscription.service.SubscriptionService;
import dev.simpleapp.demo.user.subscription.usecase.SubscriptionAddUseCase;
import dev.simpleapp.demo.user.subscription.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionAddUseCaseFacade implements SubscriptionAddUseCase {

    private final SubscribeRequestToSubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionAddUseCaseFacade(SubscribeRequestToSubscriptionMapper subscriptionMapper,
                                        SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }


    @Override
    public void subscribe(SubscribeRequest subscribeRequest) {
        Subscription subscription = this.subscriptionMapper.map(subscribeRequest);
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if (follower.equals(followed)) {
            throw new TwitterException("Подписка на самого себя не имеет никакого смысла");
        }

        if (this.subscriptionService.existsSubscription(subscription)) {
            String errorMessage = String.format(
                    "Вы уже подписаны на %s",
                    followed.getNickname()
            );
            throw new TwitterException(errorMessage);
        }

        this.subscriptionService.createSubscription(subscription);
    }
}
