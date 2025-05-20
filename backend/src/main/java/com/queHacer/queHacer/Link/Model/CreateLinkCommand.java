package com.queHacer.queHacer.Link.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLinkCommand {

    private Integer eventId;
    private String url;
    private String alt;

}
