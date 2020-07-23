package com.PDMA.controller;

import com.PDMA.entity.Taobao;
import com.PDMA.service.TaobaoService;
import com.PDMA.utils.msg.TaobaoMultiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaobaoController {
    @Autowired
    private TaobaoService taobaoService;

    @RequestMapping(value="/getTaobao")
    public List<Taobao> getTaobao(Long userId){
        return taobaoService.getTaobao(userId);
    }
}
