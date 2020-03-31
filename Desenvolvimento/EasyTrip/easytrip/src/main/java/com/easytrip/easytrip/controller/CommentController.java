package com.easytrip.easytrip.controller;


import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Comment;
import com.easytrip.easytrip.repository.CommentRepository;
import com.easytrip.easytrip.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ItineraryRepository itineraryRepository;

    //GET
    @GetMapping("/itinerary/{itineraryId}/comments")
    public List<Comment> getCommentsByItineraryId(@PathVariable Long itineraryId) {
        return commentRepository.findByItineraryId(itineraryId);
    }

    //POST
    @PostMapping("/itinerary/{itineraryId}/comments")
    public Comment addComment(@PathVariable Long itineraryId,
                        @Valid @RequestBody Comment comments) {
        return itineraryRepository.findById(itineraryId)
                .map(itinerary -> {
                    comments.setItinerary(itinerary);
                    return commentRepository.save(comments);
                }).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
    }

    @PutMapping("/itinerary/{itineraryId}/comments/{commentsId}")
    public Comment updateComment(@PathVariable Long itineraryId,
                           @PathVariable Long commentsId,
                           @Valid @RequestBody Comment commentRequest) {
        if(!itineraryRepository.existsById(itineraryId)) {
            throw new ResourceNotFoundException("Itinerary not found with id " + itineraryId);
        }

        return commentRepository.findById(commentsId)
                .map(comment -> {
                    comment.setComment(commentRequest.getComment());
                    comment.setRating(commentRequest.getRating());

                    return commentRepository.save(comment);
                }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentsId));
    }

    //Delete
    @DeleteMapping("/itinerary/{itineraryId}/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long itineraryId,
                                          @PathVariable Long commentId) {
        if(!itineraryRepository.existsById(itineraryId)) {
            throw new ResourceNotFoundException("Itinerary not found with id " + itineraryId);
        }

        return commentRepository.findById(commentId)
                .map(comment -> {
                    commentRepository.delete(comment);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId));

    }
}
