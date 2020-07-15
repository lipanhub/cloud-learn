package lipan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author 28248 2020/07/14 19:17
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * applicationContext.xml <bean id="" class=""> </bean>
     * LoadBalanced 负载均衡
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
