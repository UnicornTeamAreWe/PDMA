package com.PDMA.serviceimpl;

import com.PDMA.dao.WeiboDao;
import com.PDMA.entity.Weibo;
import com.PDMA.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeiboServiceImpl implements WeiboService {
    private final WeiboDao weiboDao;

    @Autowired
    public WeiboServiceImpl(WeiboDao weiboDao) {
        this.weiboDao = weiboDao;
    }

    @Override
    public Weibo getWeibo(Long userId) {
        Weibo WeiboList = weiboDao.findByUserId(userId);
        return WeiboList;
    }
}
