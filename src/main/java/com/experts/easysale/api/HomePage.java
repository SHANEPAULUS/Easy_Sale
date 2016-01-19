package com.experts.easysale.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SHANE on 2015/10/13.
 */
@RestController
@RequestMapping(value="/")
public class HomePage {
    @RequestMapping(method= RequestMethod.GET)
    public String Index()
    {
        return "Welcome to our mobile auction app";
    }
}
