package io.pivotal.cf.service.connector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

@Slf4j
public class HelloServiceInfoCreator extends CloudFoundryServiceInfoCreator<HelloServiceInfo> {

    public HelloServiceInfoCreator() {
        super(new Tags("hello"), HelloServiceInfo.URI_SCHEME);
    }

    @Override
    public HelloServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        log.info("Returning hello service info: " + serviceData.toString());

        Map<String, Object> credentials = getCredentials(serviceData);
        String id = getId(serviceData);
        String uri = getUriFromCredentials(credentials);
        String username = credentials.get("username").toString();
        String password = credentials.get("password").toString();

        return new HelloServiceInfo(id, uri, username, password);
    }
}