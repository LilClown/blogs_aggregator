package dev.simpleapp.demo.user.subscription.usecase;

import dev.simpleapp.demo.user.subscription.web.model.UnsubscribeRequest;

public interface SubscriptionDeleteUseCase {
    void unsubscribe(UnsubscribeRequest unsubscribeRequest);
}
