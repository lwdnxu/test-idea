package com.lagou.service.impl;

import com.lagou.service.TestService;
import com.lagou.dao.TestMapper;
import com.lagou.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 生成实例，存到IOC容器中
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        return testMapper.findAll();
    }
}
