package com.rodrigopetito.pets.model;

import java.util.List;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class Pet {

    private Long id;
    private PetCategory category;
    private String name;
    private List<String> photosUrls;
    private List<PetTag> tags;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotosUrls() {
        return photosUrls;
    }

    public void setPhotosUrls(List<String> photosUrls) {
        this.photosUrls = photosUrls;
    }

    public List<PetTag> getTags() {
        return tags;
    }

    public void setTags(List<PetTag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
