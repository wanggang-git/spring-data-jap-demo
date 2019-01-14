package com.wg.japdemo.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: wanggang.io
 * @Date: 2018/9/6 13:01
 * @todo
 */
@Configuration
public class FaJsonConfig implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullBooleanAsFalse);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }
}
/*public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
 *//**
 * 1  预先定义一个Converters 转换消息的对象
 * 2 添加fastjson的配置信息
 * 3 早converter中添加配置信息
 * 4.将converter添加到converters中
 */
/*
        super.configureMessageConverters(converters);//
        FastJsonHttpMessageConverter fastConstructor=new FastJsonHttpMessageConverter();//1
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);//2
        fastConstructor.setFastJsonConfig(fastJsonConfig);//3
        converters.add(fastConstructor);//4
    }*/