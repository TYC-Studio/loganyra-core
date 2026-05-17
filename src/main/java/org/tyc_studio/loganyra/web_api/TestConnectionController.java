package org.tyc_studio.loganyra.web_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tyc_studio.loganyra.LoganyraApplication;
import org.tyc_studio.loganyra.entities.LogEntity;
import org.tyc_studio.loganyra.jdbc.LogDAO;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestConnectionController {
    private static final Logger LOG = LoggerFactory.getLogger(TestConnectionController.class);
    @Autowired
    public Environment env;

    @Autowired
    LogDAO logDAO;

    @GetMapping("/test")
    public Map<String,String> testConnection() {
        LogEntity logByID = logDAO.getLogByID(1);
        String var1 = null;
        if (logByID != null) {
            var1 = logByID.toString();
        }
        //LOG.info(logDAO.getByAppName("service").toString());
        return Map.of("status", "success", "version", LoganyraApplication.VERSION == null ? "null" : LoganyraApplication.VERSION, "database_type", Arrays.asList(env.getActiveProfiles()).contains("mysql") ? "mysql" : "h2", "first_log", var1);
    }
}
