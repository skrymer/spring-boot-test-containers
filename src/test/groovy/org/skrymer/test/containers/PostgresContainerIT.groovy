package org.skrymer.test.containers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
@SpringBootTest()
@ActiveProfiles('test')
class PostgresContainerIT extends Specification {

    @Autowired
    JdbcTemplate db

    @Shared
    PostgreSQLContainer testContainer = SharedPostgreSQLContainer.getInstance()

    def "flyway migration scripts have been executed successfully" () {
        expect:
        db.queryForList("SELECT * FROM links").size() == 3
    }
}