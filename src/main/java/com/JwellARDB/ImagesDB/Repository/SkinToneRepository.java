package com.JwellARDB.ImagesDB.Repository;



import com.JwellARDB.ImagesDB.entity.SkinTone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkinToneRepository extends JpaRepository<SkinTone, Long> {
    Optional<SkinTone> findByToneName(String toneName);
}
