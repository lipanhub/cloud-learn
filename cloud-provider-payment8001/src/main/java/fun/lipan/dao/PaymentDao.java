package fun.lipan.dao;

import fun.lipan.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description
 *
 * @author 28248 2020/07/14 16:06
 */
@Mapper
public interface PaymentDao {
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
