package com.PDMA.service;

import com.PDMA.entity.Taobao_Analysis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaobaoAnalysisService {
    List<Taobao_Analysis> getTaobaoAnalysis(Long userId);
}
