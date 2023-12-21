package dev.simpleapp.demo.user.subscription.service;

import dev.simpleapp.demo.user.subscription.model.Subscription;

public interface SubscriptionService {
    void createSubscription(Subscription subscription);

    void deleteSubscription(Subscription subscription);

    boolean existsSubscription(Subscription subscription);
}
