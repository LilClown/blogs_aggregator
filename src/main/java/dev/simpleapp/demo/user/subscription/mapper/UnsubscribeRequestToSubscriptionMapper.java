package dev.simpleapp.demo.user.subscription.mapper;

import dev.simpleapp.demo.common.mapper.Mapper;
import dev.simpleapp.demo.user.subscription.model.Subscription;
import dev.simpleapp.demo.user.subscription.web.model.UnsubscribeRequest;

public interface UnsubscribeRequestToSubscriptionMapper extends Mapper<Subscription, UnsubscribeRequest> {
}
