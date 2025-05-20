package com.queHacer.queHacer.ReviewEvent.Service;

import com.queHacer.queHacer.Command;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewEventService implements Command<Integer, Void> {



    @Override
    public ResponseEntity<Void> execute(Integer input) {
        return null;
    }
}
