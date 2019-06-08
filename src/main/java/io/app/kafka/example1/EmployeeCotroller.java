package io.app.kafka.example1;

import io.app.kafka.framework.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping("/employee")
public class EmployeeCotroller extends BaseController<String, String> {

    private EmployeeService employeeService;

    public EmployeeCotroller(EmployeeService employeeService) {
        super(employeeService);
        this.employeeService = employeeService;
    }
}
