package com.PDMA.daoimpl;

import com.PDMA.dao.SoftwareDao;
import com.PDMA.entity.Software;
import com.PDMA.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SoftwareDaoImpl implements SoftwareDao {
    SoftwareRepository softwareRepository;

    @Autowired
    public SoftwareDaoImpl(SoftwareRepository softwareRepository){
        this.softwareRepository = softwareRepository;
    }

    @Override
    public List<Software> findAllByUserId(Long userId) {
        List<Software> list = softwareRepository.findByUserId(userId);
        return list;
    }

    @Override
    public void addSoftware(Software software) {
        softwareRepository.save(software);
    }

    @Override
    @Modifying
    @Transactional
    public void deleteSoftware(Long userId, String SoftwareName) {
        softwareRepository.deleteAllByUserIdAndSoftwareName(userId,SoftwareName);
    }

}
