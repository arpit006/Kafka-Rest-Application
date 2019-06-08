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
public abstract class BaseController<K, V> {

    private BaseService<K,V> baseService;

    public BaseController(BaseService<K, V> baseService) {
        this.baseService = baseService;
    }

    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    public V postToTopic(@RequestBody V inJson) {
        return baseService.postToTopic(inJson);
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public V consumeFromTopic() {
        return baseService.consumeFromTopic();
    }
}
