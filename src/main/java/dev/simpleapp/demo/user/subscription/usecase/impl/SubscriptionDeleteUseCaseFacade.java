package dev.simpleapp.demo.user.subscription.usecase.impl;

import dev.simpleapp.demo.common.exception.TwitterException;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.subscription.mapper.UnsubscribeRequestToSubscriptionMapper;
import dev.simpleapp.demo.user.subscription.model.Subscription;
import dev.simpleapp.demo.user.subscription.service.SubscriptionService;
import dev.simpleapp.demo.user.subscription.usecase.SubscriptionDeleteUseCase;
import dev.simpleapp.demo.user.subscription.web.model.UnsubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDeleteUseCaseFacade implements SubscriptionDeleteUseCase {

    private final UnsubscribeRequestToSubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionDeleteUseCaseFacade(UnsubscribeRequestToSubscriptionMapper subscriptionMapper,
                                           SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void unsubscribe(UnsubscribeRequest unsubscribeRequest) {
        Subscription subscription = this.subscriptionMapper.map(unsubscribeRequest);

        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if (follower.equals(followed)) {
            throw new TwitterException("Отписка от самого себя не имеет никакого смысла");
        }

        if(!this.subscriptionService.existsSubscription(subscription)) {
            String errorMessage = String.format(
                    "Вы не были подписаны на %s",
                    followed.getNickname()
            );
            throw new TwitterException(errorMessage);
        }
        this.subscriptionService.deleteSubscription(subscription);
    }
}
