package com.PDMA.dao;

import com.PDMA.entity.Taobao_Analysis;

import java.util.List;

public interface TaobaoAnalysisDao {
    List<Taobao_Analysis> findAllByUserId(Long userId);
}
