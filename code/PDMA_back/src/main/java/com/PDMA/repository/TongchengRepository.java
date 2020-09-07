package com.PDMA.repository;

import com.PDMA.entity.Tongcheng;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TongchengRepository extends JpaRepository<Tongcheng,String>{
    List<Tongcheng> findByUserId(Long userId);
}
