package fun.lipan.controller;


import fun.lipan.entities.CommonResult;
import fun.lipan.entities.Payment;
import fun.lipan.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * description
 *
 * @author 28248 2020/07/14 19:13
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    //@Resource
    //private DiscoveryClient discoveryClient;

    //@Resource
    //private MyLoadBalancer myLoadBalancer;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 路由规则: 轮询
     * http://localhost/consumer/payment/payment/lb
     *
     * @return
     */
//    @GetMapping(value = "/consumer/payment/lb")
//    public String getPaymentLB() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        if (instances == null || instances.size() <= 0) {
//            return null;
//        }
//        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//        return restTemplate.getForObject(uri + "/payment/lb", String.class);
//    }
}
