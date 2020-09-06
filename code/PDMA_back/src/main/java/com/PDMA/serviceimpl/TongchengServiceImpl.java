package com.PDMA.serviceimpl;

import com.PDMA.dao.TongchengDao;
import com.PDMA.entity.Tongcheng;
import com.PDMA.service.TongchengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongchengServiceImpl implements TongchengService {
    private final TongchengDao tongchengDao;

    @Autowired
    public TongchengServiceImpl(TongchengDao tongchengDao) {
        this.tongchengDao = tongchengDao;
    }

    @Override
    public List<Tongcheng> getTongcheng(Long userId) {
        List<Tongcheng> TongchengList = tongchengDao.findAllByUserId(userId);
        return TongchengList;
    }
}
