package com.PDMA.daoimpl;

import com.PDMA.dao.TaobaoDao;
import com.PDMA.entity.Taobao;
import com.PDMA.repository.TaobaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public class TaobaoDaoImpl implements TaobaoDao {
    TaobaoRepository taobaoRepository;

    @Autowired
    public TaobaoDaoImpl(TaobaoRepository taobaoRepository){
        this.taobaoRepository = taobaoRepository;
    }

    @Override
    public List<Taobao> findAllByUserId(Long userId) {
        List<Taobao> list = taobaoRepository.findByUserId(userId);
        return list;
    }

    @Modifying
    @Transactional
    @Override
    public void deleteTaobao(Long userId, Date Transaction_time) {
        taobaoRepository.deleteAllByUserIdAndTransactiontime(userId,Transaction_time);
    }

}
