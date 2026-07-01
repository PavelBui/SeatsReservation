package com.itpu.internship.seats_reservation.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Database configuration for PostgreSQL
 * Configures JPA repositories, entity scanning and transaction management
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.itpu.internship.seats_reservation.repositories")
@EntityScan(basePackages = "com.itpu.internship.seats_reservation.entities")
@EnableTransactionManagement
public class DatabaseConfig {
}