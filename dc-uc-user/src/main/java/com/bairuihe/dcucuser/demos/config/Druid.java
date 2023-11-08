// package com.bairuihe.dcucuser.demos.config;
//
// import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
// import org.springframework.aop.support.DefaultPointcutAdvisor;
// import org.springframework.aop.support.JdkRegexpMethodPointcut;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.EnableAspectJAutoProxy;
// import org.springframework.context.annotation.Scope;
//
// /**
//  * @Author ouyang    @Date 2023/11/3 0003
//  * @Description 测试德鲁伊监控spring
//  * http://localhost:8010/druid/login.html(以本地为例 登录密码在配置中）
//  * @menu
//  */
//
// @Configuration
// @EnableAspectJAutoProxy(proxyTargetClass = true)
// public class Druid{
//
//     @Bean
//     public DruidStatInterceptor druidStatInterceptor() {
//         DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
//         return dsInterceptor;
//     }
//     @Bean
//     @Scope("prototype")
//     public JdkRegexpMethodPointcut druidStatPointcut() {
//         JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//         pointcut.setPatterns("com.bairuihe.dcucuser.demos.mappper.*","com.bairuihe.dcucuser.demos.service.*");
//         //使用时只需将com.1111.2222.替换为你需要监控的路径
//         return pointcut;
//     }
//     @Bean
//     public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
//         DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
//         defaultPointAdvisor.setPointcut(druidStatPointcut);
//         defaultPointAdvisor.setAdvice(druidStatInterceptor);
//         return defaultPointAdvisor;
//
//
//     }
// }
