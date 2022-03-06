package com.jpa.example.dao;
import com.jpa.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TestJpaRepository extends JpaRepository<UserEntity,Long> {

    Object findByStudentAndUserName(String userName,String student);

    @Modifying
    @Query(value = "delete from  #{#entityName} a where a.userName = ?1")
    void testDelete(String name);
}
