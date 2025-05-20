package com.queHacer.queHacer.Tag.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Tag.Model.Tag;
import com.queHacer.queHacer.Tag.Model.TagDTO;
import com.queHacer.queHacer.Tag.Repository.TagRepository;
import com.queHacer.queHacer.Tag.Validators.TagValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTagService implements Command<Tag, TagDTO> {

    private final TagRepository tagRepository;

    public CreateTagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public ResponseEntity<TagDTO> execute(Tag input) {
        //Valida datucos
        TagValidator.execute(input);

        //Los guarda
        Tag tag = tagRepository.save(input);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TagDTO(tag));
    }
}
