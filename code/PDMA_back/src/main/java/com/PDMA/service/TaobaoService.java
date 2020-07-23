package com.PDMA.service;

import com.PDMA.entity.Taobao;
import com.PDMA.utils.msg.TaobaoMultiKeys;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaobaoService {
    List<Taobao> getTaobao(Long Taobao);
}
