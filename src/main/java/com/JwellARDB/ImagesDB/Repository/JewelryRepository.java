package com.JwellARDB.ImagesDB.Repository;

import com.JwellARDB.ImagesDB.entity.JwelryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JewelryRepository extends JpaRepository<JwelryItem, Long> {

    // Use actual field names in FaceShape and SkinTone entities
    List<JwelryItem> findDistinctByFaceShapes_ShapeNameInAndSkinTones_ToneNameIn(
            List<String> faceShapes, List<String> skinTones);
}
