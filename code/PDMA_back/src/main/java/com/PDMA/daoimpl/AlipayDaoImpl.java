package com.PDMA.daoimpl;

import com.PDMA.dao.AlipayDao;
import com.PDMA.entity.Alipay;
import com.PDMA.repository.AlipayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AlipayDaoImpl implements AlipayDao {
    AlipayRepository alipayRepository;

    @Autowired
    public AlipayDaoImpl(AlipayRepository alipayRepository){
        this.alipayRepository = alipayRepository;
    }

    @Override
    public List<Alipay> findAllByUserId(Long userId) {
        List<Alipay> list = alipayRepository.findByUserId(userId);
        return list;
    }

    @Modifying
    @Transactional
    @Override
    public void deleteAlipay(Long userId, String Transaction_number) {
        alipayRepository.deleteAllByUserIdAndTransactionNumber(userId,Transaction_number);
    }

}
