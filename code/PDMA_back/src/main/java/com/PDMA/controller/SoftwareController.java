package com.PDMA.controller;

import com.PDMA.entity.Software;
import com.PDMA.service.SoftwareService;
import com.PDMA.utils.msg.Message;
import com.PDMA.utils.msg.SoftwareMultiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoftwareController {
    @Autowired
    private SoftwareService softwareService;

    @RequestMapping(value = "/getSoftware")
    public List<Software> getSoftware(Long userId) {
        return softwareService.getSoftware(userId);
    }

    @RequestMapping(value = "/addSoftware")
    public @ResponseBody
    void addItem(Software software) {
        softwareService.addItem(software);
    }

    @RequestMapping(value = "/updateSoftware")
    public @ResponseBody
    void updateItem(Software software) {
        softwareService.updateItem(software);
    }

    @RequestMapping(value = "/deleteSoftware")
    public @ResponseBody
    void deleteItem(SoftwareMultiKeys keys) {
        softwareService.deleteItem(keys);
    }

}
