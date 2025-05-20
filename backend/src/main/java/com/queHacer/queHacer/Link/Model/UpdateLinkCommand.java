package com.queHacer.queHacer.Link.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLinkCommand {

    private Long id;
    private UpdateLinkDTO updateLinkDTO;
}
