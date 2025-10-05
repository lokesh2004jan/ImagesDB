package com.JwellARDB.ImagesDB.services;


import com.JwellARDB.ImagesDB.Repository.FaceShapeRepository;
import com.JwellARDB.ImagesDB.Repository.JewelryRepository;
import com.JwellARDB.ImagesDB.Repository.SkinToneRepository;
import com.JwellARDB.ImagesDB.entity.JwelryItem;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JweleryService {

    private final JewelryRepository jewelryRepo;
    private final FaceShapeRepository faceRepo;
    private final SkinToneRepository toneRepo;

    public JweleryService(JewelryRepository jewelryRepo, FaceShapeRepository faceRepo, SkinToneRepository toneRepo) {
        this.jewelryRepo = jewelryRepo;
        this.faceRepo = faceRepo;
        this.toneRepo = toneRepo;
    }

    public JwelryItem addJewelry(JwelryItem jewelry) {
        return jewelryRepo.save(jewelry);
    }

    public List<JwelryItem> getAllJewelry() {
        return jewelryRepo.findAll();
    }

    public List<JwelryItem> getJewelryByShapesAndTones(List<String> faceShapes, List<String> skinTones) {
        return jewelryRepo.findDistinctByFaceShapes_ShapeNameInAndSkinTones_ToneNameIn(faceShapes, skinTones);
    }
}
