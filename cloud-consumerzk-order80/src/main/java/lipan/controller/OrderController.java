package lipan.controller;


import fun.lipan.entities.CommonResult;
import fun.lipan.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * description
 *
 * @author 28248 2020/07/14 19:13
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String get(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/zk", payment, String.class);
    }
}
