package io.pivotal.cf.service.connector;

import lombok.ToString;
import org.springframework.cloud.service.ServiceInfo;

@ToString
class HelloServiceInfo implements ServiceInfo {

    static final String URI_SCHEME = "hello";

    private String uri;
    private String username;
    private String password;
    private String id;

    HelloServiceInfo(String id, String uri, String username, String password) {
        this.id = id;
        this.uri = uri;
        this.username = username;
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    @Override
    public String getId() {
        return id;
    }
}
