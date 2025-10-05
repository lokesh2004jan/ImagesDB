package com.JwellARDB.ImagesDB.Controller;

import com.JwellARDB.ImagesDB.entity.JwelryItem;
import com.JwellARDB.ImagesDB.services.JweleryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/jewelry")
@CrossOrigin(origins = "*")
public class JweleryController {

    private final JweleryService service;

    public JweleryController(JweleryService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<JwelryItemDTO> getAll() {
        return service.getAllJewelry().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter")
    public List<JwelryItemDTO> getFilteredJewelry(
            @RequestParam(required = false) String face,
            @RequestParam(required = false) String tone
    ) {
        // Convert single inputs into lists for service method
        List<String> faceList = face != null ? List.of(face) : List.of();
        List<String> toneList = tone != null ? List.of(tone) : List.of();

        return service.getJewelryByShapesAndTones(faceList, toneList).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    public JwelryItemDTO convertToDTO(JwelryItem item) {
        return new JwelryItemDTO(
                item.getId(),
                item.getName(),
                item.getDescription(),
                "http://10.0.2.2:8089/images/" + item.getImageUrl(), // serve from static folder
                item.getPrice()
        );
    }


    // Add this inner DTO class
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JwelryItemDTO {
        private Long id;
        private String name;
        private String description;
        private String imageUrl;
        private Double price;
    }
}
