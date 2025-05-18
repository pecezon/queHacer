package com.queHacer.queHacer.Link.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Link.Exceptions.LinkErrorMessages;
import com.queHacer.queHacer.Link.Exceptions.LinkNotFoundException;
import com.queHacer.queHacer.Link.Model.Link;
import com.queHacer.queHacer.Link.Repository.LinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteLinkService implements Command<Long, Void> {

    private final LinkRepository linkRepository;

    public DeleteLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long input) {
        Optional<Link> temp = linkRepository.findById(input);
        if(temp.isEmpty()){
            throw new LinkNotFoundException(LinkErrorMessages.LINK_NOT_FOUND.getMessage());
        }

        linkRepository.deleteById(input);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
