package com.PDMA.dao;

import com.PDMA.entity.Weibo;

public interface WeiboDao {
    Weibo findByUserId(Long userId);
}
