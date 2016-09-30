package io.pivotal.cf.service.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class HelloController {

    @Autowired
    private HelloRepository repo;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    String login(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) throws Exception {
        return repo.login(username, password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    String logout() {
        return repo.logout();
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    String greeting() {
        return repo.greeting();
    }
}