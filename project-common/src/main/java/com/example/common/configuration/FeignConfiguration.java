package com.example.common.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@SpringBootApplication
@EnableFeignClients
public class FeignConfiguration {
}
