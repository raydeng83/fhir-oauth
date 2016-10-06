package com.ldeng;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z00382545 on 10/4/16.
 */

@RestController
public class RestResource {

    @RequestMapping("/admin")
    public String admin() {
        return "This is the admin page";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String secured() {
        return "This is the secured page";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.POST)
    public String securedPost() {
        return "This is the secured post page";
    }

    @RequestMapping("/public")
    public String publicPage() {
        return "This is the public page";
    }
}
