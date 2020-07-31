package com.PDMA.serviceimpl;

import com.PDMA.dao.TaobaoDao;
import com.PDMA.entity.Taobao;
import com.PDMA.service.TaobaoService;
import com.PDMA.utils.msg.TaobaoMultiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaobaoServiceImpl implements TaobaoService {
    private final TaobaoDao taobaoDao;

    @Autowired
    public TaobaoServiceImpl(TaobaoDao taobaoDao) {
        this.taobaoDao = taobaoDao;
    }

    @Override
    public List<Taobao> getTaobao(Long userId) {
        List<Taobao> TaobaoList = taobaoDao.findAllByUserId(userId);
        return TaobaoList;
    }
}
