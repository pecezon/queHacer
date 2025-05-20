package com.queHacer.queHacer.Link.Validators;

import com.queHacer.queHacer.Link.Exceptions.InvalidLinkException;
import com.queHacer.queHacer.Link.Exceptions.LinkErrorMessages;
import com.queHacer.queHacer.Link.Model.CreateLinkCommand;
import com.queHacer.queHacer.Link.Model.UpdateLinkCommand;
import com.queHacer.queHacer.Link.Model.UpdateLinkDTO;

public class LinkValidator {

    public static void createValidation(CreateLinkCommand input){
        if(input.getUrl() == null){
            throw new InvalidLinkException(LinkErrorMessages.MISSING_URL.getMessage());
        }
    }
    public static void updateValidation(UpdateLinkDTO input){
        if(input.getUrl() == null){
            throw new InvalidLinkException(LinkErrorMessages.MISSING_URL.getMessage());
        }
    }
}
