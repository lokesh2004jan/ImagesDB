package com.JwellARDB.ImagesDB.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jewelry_items")
public class JwelryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "jewelry_face_shape",
            joinColumns = @JoinColumn(name = "jewelry_id"),
            inverseJoinColumns = @JoinColumn(name = "face_shape_id")
    )
    private Set<FaceShape> faceShapes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "jewelry_skin_tone",
            joinColumns = @JoinColumn(name = "jewelry_id"),
            inverseJoinColumns = @JoinColumn(name = "skin_tone_id")
    )
    private Set<SkinTone> skinTones = new HashSet<>();

    // Getters and setters

}
