package me.neoyang.yangtuoserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan({"me.neoyang.yangtuoserver.dao"})
@SpringBootApplication
public class YangtuoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangtuoServerApplication.class, args);
    }

}
