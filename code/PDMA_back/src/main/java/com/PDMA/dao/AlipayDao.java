package com.PDMA.dao;

import com.PDMA.entity.Alipay;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface AlipayDao {
    List<Alipay> findAllByUserId(Long userId);
}
