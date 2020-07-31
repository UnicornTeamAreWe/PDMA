package com.PDMA.controller;

import com.PDMA.entity.Taobao_Analysis;
import com.PDMA.service.TaobaoAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TaobaoAnalysisController {
    @Autowired
    private TaobaoAnalysisService taobaoanalysisService;

    @RequestMapping(value="/getTaobaoAnalysis")
    public List<Taobao_Analysis> getTaobaoAnalysis(@RequestParam("id") Long userId){
        return taobaoanalysisService.getTaobaoAnalysis(userId);
    }
}
