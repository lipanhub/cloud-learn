package fun.lipan.service.impl;

import fun.lipan.dao.PaymentDao;
import fun.lipan.entities.Payment;
import fun.lipan.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description
 *
 * @author 28248 2020/07/14 16:26
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
