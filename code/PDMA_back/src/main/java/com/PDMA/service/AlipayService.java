package com.PDMA.service;

import com.PDMA.entity.Alipay;
import com.PDMA.utils.msg.AlipayMultiKeys;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlipayService {
    List<Alipay> getAlipay(Long userId);
    void deleteItem(AlipayMultiKeys keys);
}
