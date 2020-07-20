package com.PDMA.repository;

import com.PDMA.entity.Taobao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaobaoRepository extends JpaRepository<Taobao,String>{
    void deleteAllByUserIdAndTransactiontime(Long userId, Date Transaction_time);
    List<Taobao> findByUserId(Long userId);
}
