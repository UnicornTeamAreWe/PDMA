package com.PDMA.service;

import com.PDMA.entity.Weibo;
import org.springframework.stereotype.Service;

@Service
public interface WeiboService {
    Weibo getWeibo(Long userId);
}
