package fun.lipan;

import fun.myrule.MyLoadBalancedRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <p>
 * 
 * </p>
 * 
 * @author 28248 2020/07/14 19:17
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-order-service",configuration = MyLoadBalancedRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
