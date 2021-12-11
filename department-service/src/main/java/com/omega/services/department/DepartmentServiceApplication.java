package com.omega.services.department;

import com.omega.services.department.model.Department;
import com.omega.services.department.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Department API", version = "1.0", description = "Documentation Department API v1.0"))
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @Bean
    DepartmentRepository repository() {
        DepartmentRepository repository = new DepartmentRepository();
        repository.add(Department.builder().organizationId(1L).name("Development").build());
        repository.add(Department.builder().organizationId(1L).name("Operations").build());
        repository.add(Department.builder().organizationId(2L).name("Development").build());
        repository.add(Department.builder().organizationId(2L).name("Operations").build());
        return repository;
    }

}
