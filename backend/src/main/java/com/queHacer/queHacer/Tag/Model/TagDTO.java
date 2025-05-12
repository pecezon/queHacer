package com.queHacer.queHacer.Tag.Model;

import lombok.Data;

@Data
public class TagDTO {

    private Integer id;
    private String name;
    private String color;

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
        this.color = tag.getColor();
    }
}
