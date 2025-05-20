package com.queHacer.queHacer.Link.Service;

import com.queHacer.queHacer.Link.Exceptions.LinkErrorMessages;
import com.queHacer.queHacer.Link.Exceptions.LinkNotFoundException;
import com.queHacer.queHacer.Link.Model.Link;
import com.queHacer.queHacer.Link.Model.LinkDTO;
import com.queHacer.queHacer.Link.Repository.LinkRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetLinkByIdService implements Query<Long, LinkDTO> {
    private final LinkRepository linkRepository;

    public GetLinkByIdService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public ResponseEntity<LinkDTO> execute(Long input) {

        Optional<Link> temp = linkRepository.findById(input);
        if(temp.isEmpty()){
            throw new LinkNotFoundException(LinkErrorMessages.LINK_NOT_FOUND.getMessage());
        }
        Link link = temp.get();
        LinkDTO response = new LinkDTO();
        response.setUrl(link.getUrl());
        response.setAlt(link.getAlt());
        response.setId(link.getId());
        return ResponseEntity.ok(response);
    }
}
