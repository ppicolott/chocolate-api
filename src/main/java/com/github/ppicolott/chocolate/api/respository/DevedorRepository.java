package com.github.ppicolott.chocolate.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.ppicolott.chocolate.api.entity.DevedorEntity;

@Repository
public interface DevedorRepository extends JpaRepository<DevedorEntity, String> {

	@Query(nativeQuery = true, value = "select * from devedores where uuid = :uuid ")
	DevedorEntity findDevedorById(@Param("uuid") String uuid);

}