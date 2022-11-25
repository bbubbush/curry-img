package com.bbubbush.curryimg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CurryImgApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurryImgApplication.class, args);
    }

}
