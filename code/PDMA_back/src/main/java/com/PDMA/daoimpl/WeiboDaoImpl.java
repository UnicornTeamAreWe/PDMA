package com.PDMA.daoimpl;

import com.PDMA.dao.WeiboDao;
import com.PDMA.entity.Weibo;
import com.PDMA.repository.WeiboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WeiboDaoImpl implements WeiboDao {
    WeiboRepository weiboRepository;

    @Autowired
    public WeiboDaoImpl(WeiboRepository weiboRepository){
        this.weiboRepository = weiboRepository;
    }

    @Override
    public Weibo findByUserId(Long userId) {
        Weibo list = weiboRepository.findByUserId(userId);
        return list;
    }
}
