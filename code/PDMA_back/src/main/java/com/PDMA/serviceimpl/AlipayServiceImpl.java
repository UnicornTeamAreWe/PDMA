package com.PDMA.serviceimpl;

import com.PDMA.dao.AlipayDao;
import com.PDMA.entity.Alipay;
import com.PDMA.service.AlipayService;
import com.PDMA.utils.msg.AlipayMultiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlipayServiceImpl implements AlipayService {
    private final AlipayDao alipayDao;

    @Autowired
    public AlipayServiceImpl(AlipayDao alipayDao) {
        this.alipayDao = alipayDao;
    }

    @Override
    public List<Alipay> getAlipay(Long userId) {
        List<Alipay> AlipayList = alipayDao.findAllByUserId(userId);
        return AlipayList;
    }

    @Override
    public void deleteItem(AlipayMultiKeys keys) {
        alipayDao.deleteAlipay(keys.getUserId(),keys.getTransaction_number());
    }

}
