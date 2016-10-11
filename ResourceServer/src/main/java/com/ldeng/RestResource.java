package com.ldeng;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z00382545 on 10/5/16.
 */

@RestController
public class RestResource {

    @RequestMapping(value = "/api/resource", method = RequestMethod.POST)
    public String getResource() {
        return "Here is the resource.";
    }

    @RequestMapping("/public/resource")
    public String getPublicResource() {
        return "Here is the public resource.";
    }
}
