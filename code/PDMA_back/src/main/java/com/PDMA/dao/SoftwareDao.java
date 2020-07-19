package com.PDMA.dao;

import com.PDMA.entity.Software;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface SoftwareDao {
    List<Software> findAllByUserId(Long userId);
    void addSoftware(Software software);
    @Modifying
    @Transactional
    void deleteSoftware(Long userId, String SoftwareName);
}
