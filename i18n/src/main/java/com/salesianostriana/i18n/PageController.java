package com.salesianostriana.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
 
    @GetMapping("/")
    public String getInternationalPage() {
        return "home";
    }
}