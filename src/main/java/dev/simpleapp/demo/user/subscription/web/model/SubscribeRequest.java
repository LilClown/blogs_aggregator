package dev.simpleapp.demo.user.subscription.web.model;

import jakarta.validation.constraints.NotNull;

public record SubscribeRequest(@NotNull Long followedId) {
}
