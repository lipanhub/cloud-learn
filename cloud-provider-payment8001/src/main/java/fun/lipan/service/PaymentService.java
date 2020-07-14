package fun.lipan.service;


import fun.lipan.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * description
 *
 * @author 28248 2020/07/14 16:24
 */
public interface PaymentService {
    /**
     * @param null
     * @return
     * @author 28248 2020-07-14 16:08
     */
    int create(Payment payment);

    /**
     * @param null
     * @return
     * @author 28248 2020-07-14 16:08
     */
    Payment getPaymentById(@Param("id") Long id);
}
