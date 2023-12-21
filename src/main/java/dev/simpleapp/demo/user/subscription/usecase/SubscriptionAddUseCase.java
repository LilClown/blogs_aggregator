package dev.simpleapp.demo.user.subscription.usecase;

import dev.simpleapp.demo.user.subscription.web.model.SubscribeRequest;

public interface SubscriptionAddUseCase {
    void subscribe(SubscribeRequest subscribeRequest);
}
