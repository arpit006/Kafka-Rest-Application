package io.app.kafka.example;

import io.app.kafka.framework.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class BusinessService extends BaseService<String> {

    private final
    BusinessProducer businessProducer;

    private final
    BusinessConsumer businessConsumer;

    public BusinessService(BusinessProducer businessProducer, BusinessConsumer businessConsumer) {
        super(businessProducer, businessConsumer);
        this.businessProducer = businessProducer;
        this.businessConsumer = businessConsumer;
    }
}
