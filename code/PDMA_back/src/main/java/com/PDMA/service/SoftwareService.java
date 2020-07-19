package com.PDMA.service;

import com.PDMA.entity.Software;
import com.PDMA.utils.msg.SoftwareMultiKeys;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SoftwareService {
    List<Software> getSoftware(Long userId);
    void addItem(Software software);
    void updateItem(Software software);
    void deleteItem(SoftwareMultiKeys keys);
}
