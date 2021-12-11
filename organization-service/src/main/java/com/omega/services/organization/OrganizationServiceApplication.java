package com.omega.services.organization;

import com.omega.services.organization.model.Organization;
import com.omega.services.organization.repository.OrganizationRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Organization API", version = "1.0", description = "Documentation Organization API v1.0"))
public class OrganizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
    }

    @Bean
    OrganizationRepository repository() {
        OrganizationRepository repository = new OrganizationRepository();
        repository.add(Organization.builder().name("Microsoft").address("Redmond, Washington, USA").build());
        repository.add(Organization.builder().name("Oracle").address("Redwood City, California, USA").build());
        return repository;
    }

}
