package com.example.nettytest.service;

import com.example.nettytest.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Package: com.example.nettytest
 * @ClassName: BaseServiceImpl
 * @Author: yinj
 * @CreateTime: 2021/1/6 15:36
 * @Description: TODO
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Override
    public void test() {
        System.out.println("调用service服务");
    }
}
