package com.PDMA.repository;

import com.PDMA.entity.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<Software,String>{
    void deleteAllByUserIdAndSoftwareName(Long userId, String softwareName);
    List<Software> findByUserId(Long userId);
}
