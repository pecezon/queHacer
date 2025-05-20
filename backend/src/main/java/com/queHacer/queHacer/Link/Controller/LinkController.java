package com.queHacer.queHacer.Link.Controller;

import com.queHacer.queHacer.Link.Exceptions.InvalidLinkException;
import com.queHacer.queHacer.Link.Exceptions.LinkErrorResponse;
import com.queHacer.queHacer.Link.Exceptions.LinkNotFoundException;
import com.queHacer.queHacer.Link.Model.CreateLinkCommand;
import com.queHacer.queHacer.Link.Model.LinkDTO;
import com.queHacer.queHacer.Link.Model.UpdateLinkCommand;
import com.queHacer.queHacer.Link.Model.UpdateLinkDTO;
import com.queHacer.queHacer.Link.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final CreateLinkService createLinkService;
    private final UpdateLinkService updateLinkService;
    private final DeleteLinkService deleteLinkService;
    private final GetLinkByIdService getLinkByIdService;
    private final GetLinksForEventService getLinksForEventService;

    public LinkController(CreateLinkService createLinkService, UpdateLinkService updateLinkService, DeleteLinkService deleteLinkService, GetLinkByIdService getLinkByIdService, GetLinksForEventService getLinksForEventService) {
        this.createLinkService = createLinkService;
        this.updateLinkService = updateLinkService;
        this.deleteLinkService = deleteLinkService;
        this.getLinkByIdService = getLinkByIdService;
        this.getLinksForEventService = getLinksForEventService;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('EVENT_CREATOR')")
    @PostMapping
    public ResponseEntity<LinkDTO> createLinkForEvent(@RequestBody CreateLinkCommand input){
        return createLinkService.execute(input);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping("/{id}")
    public ResponseEntity<LinkDTO> updateLink(@PathVariable Long id, @RequestBody UpdateLinkDTO updateLinkDTO){
        return updateLinkService.execute(new UpdateLinkCommand(id,updateLinkDTO));
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLink(@PathVariable Long id){
        return deleteLinkService.execute(id);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/{id}")
    public ResponseEntity<LinkDTO> getLinkById(@PathVariable Long id){
        return getLinkByIdService.execute(id);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<LinkDTO>> getLinksForEvent(@PathVariable Integer eventId){
        return getLinksForEventService.execute(eventId);
    }

    @ExceptionHandler(InvalidLinkException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public LinkErrorResponse handleInvalidLinkException(InvalidLinkException exception){
        return new LinkErrorResponse(exception.getMessage());
    }
    @ExceptionHandler(LinkNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public LinkErrorResponse handleLinkNotFoundException(LinkNotFoundException exception){
        return new LinkErrorResponse(exception.getMessage());
    }

}
