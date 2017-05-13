package com.v2.myskeleton.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.v2.myskeleton.Entity.UserEntity;

@Repository
public interface UserEntityRepository  extends JpaRepository<UserEntity, Long> {
	public UserEntity findByUsername(String username);
}
