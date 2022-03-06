package com.jpa.example.service;

import com.jpa.example.dao.TestJpaRepository;
import com.jpa.example.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class JpaTestServiceImpl implements JpaTestService {
    @Autowired
    TestJpaRepository testJpaRepository;

    @Override
    public Object findAll() {
        return testJpaRepository.findAll();
    }

    @Override
    public Object findById() {
        long id = 1l;
        return testJpaRepository.findById(id);
    }

    @Override
    public Object save() {
        UserEntity userEntity =  new UserEntity();
        userEntity.setUserName("xiaoyu");
        userEntity.setStudent("川大");
        testJpaRepository.save(userEntity);
        return null;
    }

    @Override
    public Object update() {
        long id = 1l;
        Optional<UserEntity> byId = testJpaRepository.findById(id);
        if (byId.isPresent()) {
            UserEntity userEntity = byId.get();
            userEntity.setUserName("update 小鱼");
            testJpaRepository.save(userEntity);
            return userEntity;
        }
        return null;
    }

    @Override
    public Object delete() {
        long id = 1l;
        testJpaRepository.deleteById(id);
        return null;
    }

    @Override
    public Object special() {
        String username = "四川";
        String student = "成都";
        return testJpaRepository.findByStudentAndUserName(username,student);
    }

    @Override
    @Transactional
    public Object deleteSpecial() {
        String name = "测试特殊删除";
        testJpaRepository.testDelete(name);
        return "OK";
    }
}
