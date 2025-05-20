package com.queHacer.queHacer.Tag.Controller;

import com.queHacer.queHacer.Tag.Model.Tag;
import com.queHacer.queHacer.Tag.Model.TagDTO;
import com.queHacer.queHacer.Tag.Service.CreateTagService;
import com.queHacer.queHacer.Tag.Service.GetTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {

    private final CreateTagService createTagService;
    private final GetTagService getTagService;

    public TagController(CreateTagService createTagService, GetTagService getTagService) {
        this.createTagService = createTagService;
        this.getTagService = getTagService;
    }


    @PostMapping("/createTag")
    public ResponseEntity<TagDTO> createTag(@RequestBody Tag tag) {
        return createTagService.execute(tag);
    }

    @GetMapping("/getTag/{id}")
    public ResponseEntity<TagDTO> getTag(@PathVariable Integer id) {
        return getTagService.execute(id);
    }
}

