package io.pivotal.cf.service.connector;

class HelloRepository {

    private HelloServiceInfo info;

    private String user;

    HelloRepository(HelloServiceInfo info) {
        this.info = info;
    }

    String login(String user, String password) throws Exception {
        if ( ! info.getUsername().equals(user) ||  ! info.getPassword().equals(password)) {
            throw new Exception("invalid credentials");
        }

        this.user = user;

        return "user logged in.";
    }

    String logout() {
        this.user = null;
        return "User logged out.";
    }

    public String greeting() {
        if (user == null) {
            return "Sorry, I don't think we've met.";
        }
        return "Hello, " + user + "!";
    }
}