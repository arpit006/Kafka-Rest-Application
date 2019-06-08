package io.app.kafka.example;

import io.app.kafka.framework.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping("/controller")
public class BusinessController extends BaseController<String, String> {

    private final
    BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        super(businessService);
        this.businessService = businessService;
    }
}
