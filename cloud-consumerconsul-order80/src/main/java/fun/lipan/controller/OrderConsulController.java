package fun.lipan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * p34 使用Docker下载Consul后，然后本地连接虚拟机服务注册出现大红叉叉这样解决：
 * 配置文件添加这行配置重新启动即可解决问题。
 * spring.cloud.consul.discovery.prefer-ip-address=true
 * <p>
 * consul报红叉是因为consul的安全检查要检查你的服务，他会访问 ip:8006/actuator/health这个接口，
 * 如果你项目是在内网，consul是在外网那就访问不到，就会报红叉
 *
 * @author zzyy
 * @create 2020-02-18 17:23
 **/
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;


    /**
     * http://localhost/consumer/payment/consul
     *
     * @return
     */
    @GetMapping("/consumer/payment/consul")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
