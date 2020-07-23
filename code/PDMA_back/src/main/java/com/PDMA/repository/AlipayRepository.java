package com.PDMA.repository;

import com.PDMA.entity.Alipay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlipayRepository extends JpaRepository<Alipay,String>{
    List<Alipay> findByUserId(Long userId);
}
