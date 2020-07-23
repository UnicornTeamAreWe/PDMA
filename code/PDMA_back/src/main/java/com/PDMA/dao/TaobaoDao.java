package com.PDMA.dao;

import com.PDMA.entity.Taobao;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface TaobaoDao {
    List<Taobao> findAllByUserId(Long userId);
}
