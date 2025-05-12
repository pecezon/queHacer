package com.queHacer.queHacer.Tag.Service;

import com.queHacer.queHacer.Exceptions.TagNotFoundException;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.Tag.Model.Tag;
import com.queHacer.queHacer.Tag.Model.TagDTO;
import com.queHacer.queHacer.Tag.Repository.TagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTagService implements Query<Integer, TagDTO> {

    private final TagRepository tagRepository;

    public GetTagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public ResponseEntity<TagDTO> execute(Integer input) {
        Optional<Tag> tag = tagRepository.findById(input);

        if (tag.isPresent()) {
            return ResponseEntity.ok(new TagDTO(tag.get()));
        }

        throw new TagNotFoundException();
    }
}
