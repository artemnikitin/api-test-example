package com.artemnikitin.api.tests.config;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static final com.typesafe.config.Config cfg = ConfigFactory.parseFile(
            new File("api-tests.conf")).resolve();

    public static String getHost() {
        return getValueFromDiffSources("VULNERS_HOST");
    }

    public static String getUrl() {
        return getValueFromDiffSources("VULNERS_URL");
    }

    private static String getValueFromDiffSources(String text) {
        String env = System.getenv(text);
        String property = System.getProperty(toLower(text), "");
        if (env != null && !env.equals(""))
            return env;
        else if (!property.equals(""))
            return property;
        else
            return cfg.getString("api-tests." + toLower(text));
    }

    private static String toLower(String text) {
        if (text == null) return "";
        return text.toLowerCase().replace("_", ".");
    }

}
