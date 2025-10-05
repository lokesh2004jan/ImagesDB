package com.JwellARDB.ImagesDB.Repository;



import com.JwellARDB.ImagesDB.entity.FaceShape;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FaceShapeRepository extends JpaRepository<FaceShape, Long> {
    Optional<FaceShape> findByShapeName(String shapeName);
}
