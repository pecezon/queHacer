package com.queHacer.queHacer.Tag.Validators;

import com.queHacer.queHacer.Exceptions.TagNotValidException;
import com.queHacer.queHacer.Tag.Model.Tag;

public class TagValidator{


    public TagValidator() {
    }

    public static Void execute(Tag tag) {
        if (tag.getName() == null) {
            throw new TagNotValidException();
        }
        if (tag.getColor() == null || tag.getColor().length() > 7) {
            throw new TagNotValidException();
        }

        return null;
    }
}
