package com.PDMA.controller;

import com.PDMA.entity.Alipay;
import com.PDMA.service.AlipayService;
import com.PDMA.utils.msg.AlipayMultiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AlipayController {
    @Autowired
    private AlipayService alipayService;

    @RequestMapping(value="/getAlipay")
    public List<Alipay> getAlipay(@RequestParam("id")Long userId){
        System.out.println(alipayService.getAlipay(userId));
        return alipayService.getAlipay(userId);
    }
}
