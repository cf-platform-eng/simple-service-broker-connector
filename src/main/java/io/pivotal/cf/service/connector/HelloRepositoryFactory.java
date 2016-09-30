package io.pivotal.cf.service.connector;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class HelloRepositoryFactory {

    HelloRepository create(HelloServiceInfo info) {

        log.info("creating hello Repo with info: " + info);

        return new HelloRepository(info);
    }
}
