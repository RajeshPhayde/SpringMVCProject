package com.project2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.project2", "com.project2.controller", "com.project2.service", "com.project2.repo", "com.project2.entity" })
public class RecipentConfig {

}
