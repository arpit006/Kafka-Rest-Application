package io.app.kafka.example1;

import io.app.kafka.framework.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class EmployeeService extends BaseService<String, String> {

    private EmployeeProducer employeeProducer;

    private EmployeeConsumer employeeConsumer;

    public EmployeeService(EmployeeProducer employeeProducer, EmployeeConsumer employeeConsumer) {
        super(employeeProducer, employeeConsumer);
        this.employeeConsumer = employeeConsumer;
        this.employeeProducer = employeeProducer;
    }
}
