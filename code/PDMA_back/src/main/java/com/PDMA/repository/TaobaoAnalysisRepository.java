package com.PDMA.repository;

import com.PDMA.entity.Taobao_Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaobaoAnalysisRepository extends JpaRepository<Taobao_Analysis,String>{
    List<Taobao_Analysis> findByUserId(Long userId);
}
