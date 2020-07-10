package com.leyou.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class LeyouConfiguration {

    @Bean
    public CorsFilter corsFilter() {

        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true); //如果要允许携带cookie，必须指定具体域名
        corsConfiguration.addAllowedMethod("*"); //*代表所有请求方式
        corsConfiguration.addAllowedHeader("*");

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        //返回CorsFilter实例
        return  new CorsFilter(corsConfigurationSource);
    }
}
