package com.eugineer.repository;

import com.eugineer.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {

}
