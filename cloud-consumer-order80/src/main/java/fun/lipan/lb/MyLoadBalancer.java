package fun.lipan.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * description
 *
 * @author 28248 2020/07/16 10:05
 */
public interface MyLoadBalancer {
    /**
     * 获取存活的服务实例列表
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
