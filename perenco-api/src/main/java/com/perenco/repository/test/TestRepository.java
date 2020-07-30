package com.perenco.repository.test;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<TestEntity, String> {

    public TestEntity save (TestEntity entity);

}