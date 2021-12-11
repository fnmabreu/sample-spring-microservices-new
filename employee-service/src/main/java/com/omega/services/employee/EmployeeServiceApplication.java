package com.omega.services.employee;

import com.omega.services.employee.model.Employee;
import com.omega.services.employee.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0"))
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    EmployeeRepository repository() {
        EmployeeRepository repository = new EmployeeRepository();
        repository.add(Employee.builder().organizationId(1L).departmentId(1L).name("John Smith").age(34).position("Analyst").build());
        repository.add(Employee.builder().organizationId(1L).departmentId(1L).name("Darren Hamilton").age(37).position("Manager").build());
        repository.add(Employee.builder().organizationId(1L).departmentId(1L).name("Tom Scott").age(26).position("Developer").build());
        repository.add(Employee.builder().organizationId(1L).departmentId(2L).name("Anna London").age(26).position("Analyst").build());
        repository.add(Employee.builder().organizationId(1L).departmentId(2L).name("Patrick Dempsey").age(27).position("Developer").build());
        repository.add(Employee.builder().organizationId(2L).departmentId(3L).name("Kevin Price").age(38).position("Developer").build());
        repository.add(Employee.builder().organizationId(2L).departmentId(3L).name("Ian Scott").age(34).position("Developer").build());
        repository.add(Employee.builder().organizationId(2L).departmentId(3L).name("Andrew Campton").age(30).position("Manager").build());
        repository.add(Employee.builder().organizationId(2L).departmentId(4L).name("Steve Franklin").age(25).position("Developer").build());
        repository.add(Employee.builder().organizationId(2L).departmentId(4L).name("Elisabeth Smith").age(30).position("Developer").build());
        return repository;
    }

}
