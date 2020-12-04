package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author: Wangsx
 * @Date: 2020/12/4 下午4:06
 *
 *
 */

@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
