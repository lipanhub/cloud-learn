package fun.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author 28248 2020/07/15 21:11
 */
@Configuration
public class MyLoadBalancedRule {
    @Bean
    public IRule myLoadBalancedRule(){
        return new RandomRule();
    }
}
