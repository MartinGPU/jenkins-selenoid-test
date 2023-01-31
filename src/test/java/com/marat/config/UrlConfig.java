package com.marat.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/url.properties"})
public interface UrlConfig extends Config {

    String url();
}
