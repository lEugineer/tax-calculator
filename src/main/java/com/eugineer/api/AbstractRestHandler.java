package com.eugineer.api;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected ApplicationEventPublisher eventPublisher;

    protected static final String DEFAULT_SIZE = "25";
    protected static final String DEFAULT_PAGE = "0";

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
