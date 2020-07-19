package com.PDMA.serviceimpl;

import com.PDMA.dao.SoftwareDao;
import com.PDMA.entity.Software;
import com.PDMA.service.SoftwareService;
import com.PDMA.utils.msg.SoftwareMultiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareServiceImpl implements SoftwareService {
    private final SoftwareDao softwareDao;

    @Autowired
    public SoftwareServiceImpl(SoftwareDao softwareDao) {
        this.softwareDao = softwareDao;
    }

    @Override
    public List<Software> getSoftware(Long userId) {
        List<Software> SoftwareList = softwareDao.findAllByUserId(userId);
        return SoftwareList;
    }

    @Override
    public void addItem(Software software) {
        softwareDao.addSoftware(software);
    }

    @Override
    public void updateItem(Software software) {
        softwareDao.addSoftware(software);
    }

    @Override
    public void deleteItem(SoftwareMultiKeys keys) {
        softwareDao.deleteSoftware(keys.getUserId(),keys.getSoftwareName());
    }
}
