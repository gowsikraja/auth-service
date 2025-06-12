package com.gowsik.auth_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {

    /**
     * This method catches all requests under the /home/ path and forwards them
     * to the Flutter application's entry point (index.html). This is crucial
     * for making sure client-side routing (deep linking) works correctly.
     * For example, it will handle:
     * - /home
     * - /home/
     * - /home/profile
     * - /home/settings/options
     * ...and so on.
     *
     * It avoids catching requests for actual static files (like .js, .css, .png)
     * by excluding paths that contain a dot (.).
     */
    @RequestMapping(value = "/home/{path:[^\\.]*}")
    public String forwardToHomeIndex() {
        // Forward to the index.html located in /static/home/
        return "forward:/home/index.html";
    }

    /**
     * This is a fallback mapping for just "/home" or "/home/". The above mapping
     * with the path variable might not catch these two specific cases depending
     * on the Spring version. Adding this ensures they are always handled.
     */
    @RequestMapping(value = { "/home", "/home/", "/" })
    public String forwardBaseToHomeIndex() {
        return "forward:/home/index.html";
    }
}