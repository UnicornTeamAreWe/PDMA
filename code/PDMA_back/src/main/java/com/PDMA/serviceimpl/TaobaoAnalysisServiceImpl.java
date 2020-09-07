package com.PDMA.serviceimpl;

import com.PDMA.dao.TaobaoAnalysisDao;
import com.PDMA.entity.Taobao_Analysis;
import com.PDMA.service.TaobaoAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaobaoAnalysisServiceImpl implements TaobaoAnalysisService {
    private final TaobaoAnalysisDao taobaoanalysisDao;

    @Autowired
    public TaobaoAnalysisServiceImpl(TaobaoAnalysisDao taobaoanalysisDao) {
        this.taobaoanalysisDao = taobaoanalysisDao;
    }

    @Override
    public List<Taobao_Analysis> getTaobaoAnalysis(Long userId) {
        List<Taobao_Analysis> TaobaoList = taobaoanalysisDao.findAllByUserId(userId);
        return TaobaoList;
    }
}
