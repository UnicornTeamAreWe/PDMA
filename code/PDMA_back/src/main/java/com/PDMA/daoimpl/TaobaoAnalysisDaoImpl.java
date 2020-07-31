package com.PDMA.daoimpl;

import com.PDMA.dao.TaobaoAnalysisDao;
import com.PDMA.entity.Taobao_Analysis;
import com.PDMA.repository.TaobaoAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaobaoAnalysisDaoImpl implements TaobaoAnalysisDao {
    TaobaoAnalysisRepository taobaoanalysisRepository;

    @Autowired
    public TaobaoAnalysisDaoImpl(TaobaoAnalysisRepository taobaoanalysisRepository){
        this.taobaoanalysisRepository = taobaoanalysisRepository;
    }

    @Override
    public List<Taobao_Analysis> findAllByUserId(Long userId) {
        List<Taobao_Analysis> list = taobaoanalysisRepository.findByUserId(userId);
        return list;
    }
}
