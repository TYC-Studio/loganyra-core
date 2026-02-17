package org.tyc_studio.loganyra.web_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tyc_studio.loganyra.LoganyraApplication;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestConnectionController {
    @GetMapping("/test")
    public Map<String,String> testConnection(@Autowired Environment env) {
        return Map.of("status", "success", "version", LoganyraApplication.VERSION, "database_type", Arrays.asList(env.getActiveProfiles()).contains("mysql") ? "mysql" : "h2");
    }
}
