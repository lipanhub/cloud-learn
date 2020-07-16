package fun.lipan.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 *
 * @author 28248 2020/07/16 10:07
 */
@Component
public class MyRoundLoadBalancer implements MyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 :current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第 " + next + " 次访问");
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int idx = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(idx);
    }
}
