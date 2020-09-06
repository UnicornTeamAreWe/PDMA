package com.PDMA.controller;

import com.PDMA.entity.Weibo;
import com.PDMA.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class WeiboController {
    @Autowired
    private WeiboService weiboService;

    @RequestMapping(value="/getWeibo")
    public Weibo getWeibo(@RequestParam("id") Long userId){
        return weiboService.getWeibo(userId);
    }


}
