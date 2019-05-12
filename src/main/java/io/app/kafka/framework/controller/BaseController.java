package io.app.kafka.framework.controller;

import io.app.kafka.framework.service.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * This is the Rest Controller to make rest calls to Kafka.
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public abstract class BaseController<T> {

    private BaseService<T> baseService;

    public BaseController(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    public T postToTopic(@RequestBody T inJson) {
        return baseService.postToTopic(inJson);
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public T consumeFromTopic() {
        return baseService.consumeFromTopic();
    }
}
