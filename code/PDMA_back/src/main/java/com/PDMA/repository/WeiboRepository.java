package com.PDMA.repository;

import com.PDMA.entity.Weibo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeiboRepository extends JpaRepository<Weibo,String>{
    Weibo findByUserId(Long userId);
}
