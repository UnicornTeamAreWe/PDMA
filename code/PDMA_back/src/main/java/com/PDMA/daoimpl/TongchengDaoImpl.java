package com.PDMA.daoimpl;

import com.PDMA.dao.TongchengDao;
import com.PDMA.entity.Tongcheng;
import com.PDMA.repository.TongchengRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TongchengDaoImpl implements TongchengDao {
    TongchengRepository tongchengRepository;

    @Autowired
    public TongchengDaoImpl(TongchengRepository tongchengRepository){
        this.tongchengRepository = tongchengRepository;
    }

    @Override
    public List<Tongcheng> findAllByUserId(Long userId) {
        List<Tongcheng> list = tongchengRepository.findByUserId(userId);
        return list;
    }
}
