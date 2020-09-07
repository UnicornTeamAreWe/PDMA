package com.PDMA.controller;

import com.PDMA.entity.Tongcheng;
import com.PDMA.service.TongchengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TongchengController {
    @Autowired
    private TongchengService tongchengService;

    @RequestMapping(value="/getTongcheng")
    public List<Tongcheng> getTongcheng(@RequestParam("id") Long userId){
        return tongchengService.getTongcheng(userId);
    }
}
