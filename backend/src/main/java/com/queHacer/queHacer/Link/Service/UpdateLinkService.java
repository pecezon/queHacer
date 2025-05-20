package com.queHacer.queHacer.Link.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Link.Exceptions.InvalidLinkException;
import com.queHacer.queHacer.Link.Exceptions.LinkErrorMessages;
import com.queHacer.queHacer.Link.Model.Link;
import com.queHacer.queHacer.Link.Model.LinkDTO;
import com.queHacer.queHacer.Link.Model.UpdateLinkCommand;
import com.queHacer.queHacer.Link.Model.UpdateLinkDTO;
import com.queHacer.queHacer.Link.Repository.LinkRepository;
import com.queHacer.queHacer.Link.Validators.LinkValidator;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateLinkService implements Command<UpdateLinkCommand, LinkDTO> {

    private final LinkRepository linkRepository;

    public UpdateLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;

    }


    @Override
    public ResponseEntity<LinkDTO> execute(UpdateLinkCommand input) {
       Optional<Link> temp = linkRepository.findById(input.getId());
       if(temp.isEmpty()){
           throw new InvalidLinkException(LinkErrorMessages.LINK_NOT_FOUND.getMessage());
       }

       UpdateLinkDTO dto = input.getUpdateLinkDTO();

       Link link = temp.get();
        if (dto.getAlt() != null) {
            link.setAlt(dto.getAlt());
        }
        if(dto.getUrl() != null){
            link.setUrl(dto.getUrl());
        }

        Link savedLink = linkRepository.save(link);
        LinkDTO response = new LinkDTO();
        response.setId(savedLink.getId());
        response.setUrl(savedLink.getUrl());
        response.setAlt(savedLink.getAlt());

        return ResponseEntity.ok(response);
    }
}
