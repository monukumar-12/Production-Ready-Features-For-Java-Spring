package com.monu.productions_ready_features.repositories;

import com.monu.productions_ready_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {
}
