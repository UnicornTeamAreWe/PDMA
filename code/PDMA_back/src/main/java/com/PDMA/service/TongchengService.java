package com.PDMA.service;

import com.PDMA.entity.Tongcheng;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TongchengService {
    List<Tongcheng> getTongcheng(Long userId);
}
