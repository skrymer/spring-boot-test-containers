package org.skrymer.test.containers

import org.testcontainers.containers.PostgreSQLContainer

class SharedPostgreSQLContainer {
    static PostgreSQLContainer instance

    static PostgreSQLContainer getInstance() {
        if(instance == null){
            instance = new PostgreSQLContainer("postgres:11.1"){
                @Override
                void start() {
                    super.start()
                    System.setProperty("DB_URL", instance.getJdbcUrl());
                    System.setProperty("DB_USERNAME", instance.getUsername());
                    System.setProperty("DB_PASSWORD", instance.getPassword());
                }

                @Override
                void close() {}
            }
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa")
        }

        return instance
    }

}
