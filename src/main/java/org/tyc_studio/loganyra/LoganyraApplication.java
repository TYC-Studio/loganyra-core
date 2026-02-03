package org.tyc_studio.loganyra;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class LoganyraApplication {
    private static final Logger LOG = LoggerFactory.getLogger(LoganyraApplication.class);

    @Autowired
    public Environment ENV;

    @SuppressWarnings("deprecated")
    public static void main(String[] args) {
        SpringApplication.run(LoganyraApplication.class, args);
    }

    @Component
    public class LoganyraApplicationRunner implements ApplicationRunner {
        // 启动后立即执行
        @Override
        public void run(@NonNull ApplicationArguments args) {
            LOG.info("Loganyra Core version %s starting in %s profile.".formatted(LoganyraApplication.class.getPackage().getImplementationVersion(), Arrays.toString(ENV.getActiveProfiles())));
        }
    }
}
