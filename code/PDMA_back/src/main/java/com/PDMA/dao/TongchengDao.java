package com.PDMA.dao;

import com.PDMA.entity.Tongcheng;

import java.util.List;

public interface TongchengDao {
    List<Tongcheng> findAllByUserId(Long userId);
}
