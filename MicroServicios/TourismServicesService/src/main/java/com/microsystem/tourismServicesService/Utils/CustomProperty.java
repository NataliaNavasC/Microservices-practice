package com.microsystem.tourismServicesService.Utils;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "soap")
public class CustomProperty {

    /**
     * Description of the property 'def'.
     */
    @NotNull private String url = "";  // <- default value of the property

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // other props...
    
}