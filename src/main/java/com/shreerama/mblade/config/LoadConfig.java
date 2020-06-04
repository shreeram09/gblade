package com.shreerama.mblade.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.blade.Blade;
import com.blade.ioc.annotation.Bean;
import com.blade.loader.BladeLoader;

import io.github.biezhi.anima.Anima;

@Bean
public class LoadConfig implements BladeLoader {

    @Override
    public void load(Blade blade) {
        // Environment environment = blade.environment();
        // Map<String, Object> map = environment.getPrefix("jdbc");
        // if (map.containsKey("database")) {
        //     JdbcConfig jdbcConfig = JdbcConfig.builder().driver("org.postgresql.Driver").url(map.get("url").toString())
        //             .username(map.get("username").toString()).password(map.get("password").toString()).build();
        // }
        DruidDataSource dataSource = new DruidDataSource() ;

        dataSource.setDriverClassName(blade.environment().getOrNull("jdbc.driver"));
        dataSource.setUrl(blade.environment().getOrNull("jdbc.url"));
        dataSource.setUsername(blade.environment().getOrNull("jdbc.username"));
        dataSource.setPassword(blade.environment().getOrNull("jdbc.password"));

        dataSource.setInitialSize(5);
        dataSource.setMaxActive(5);
        dataSource.setMinIdle(2);
        dataSource.setMaxWait(6000);

        Anima.open(dataSource);
    }
}