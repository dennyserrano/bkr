package org.bkr.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@EnableAutoConfiguration
@EnableJpaRepositories("org.bkr.services.repo")
@EntityScan("org.bkr.models")
@ComponentScan({"org.bkr.services.service"})
public class Conf {

}
