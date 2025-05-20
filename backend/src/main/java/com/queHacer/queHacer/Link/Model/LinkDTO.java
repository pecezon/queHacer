package com.queHacer.queHacer.Link.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private Long id;
    private String url;
    private String alt;

    public LinkDTO(Link link) {
        this.id = link.getId();
        this.url = link.getUrl();
        this.alt = link.getAlt();
    }
}
