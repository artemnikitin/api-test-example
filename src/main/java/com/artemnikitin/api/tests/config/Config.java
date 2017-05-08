package com.artemnikitin.api.tests.config;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static final com.typesafe.config.Config cfg = ConfigFactory.parseFile(
            new File("api-tests.conf"));

    public static String getHost() {
        String env = System.getenv("VULNERS_HOST");
        String property = System.getProperty("vulners.host", "");
        if (env != null)
            return env;
        else if (!property.equals(""))
            return property;
        else
            return cfg.getString("api-tests.vulners.host");
    }

}
