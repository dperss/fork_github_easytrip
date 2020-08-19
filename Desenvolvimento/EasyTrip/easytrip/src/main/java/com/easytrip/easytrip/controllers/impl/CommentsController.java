package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Accommodation;
import com.easytrip.easytrip.models.Comment;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.services.impl.AccommodationServiceImpl;
import com.easytrip.easytrip.services.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/comments")
public class CommentsController implements Controller<Comment> {


    @Autowired
    private CommentServiceImpl commentService;



    @Override
    public ResponseEntity<Page<Comment>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
            return new ResponseEntity<>(commentService.findAll(
                    PageRequest.of(
                            pageNumber, pageSize,
                            sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                    )
            ), HttpStatus.OK);}catch (Exception e){
            System.out.println("PError");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<Comment> findById(Long id) {

        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);


    }



    @Override
    public ResponseEntity<Comment> save(Comment comment) {
        System.out.println("Trip created");
        return new ResponseEntity<>(commentService.saveOrUpdate(comment), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Comment> update(Comment comment) {
        System.out.println("Comment Updated");
        return new ResponseEntity<>(commentService.saveOrUpdate(comment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Comment deleted ID:" + id);
        return new ResponseEntity<>(commentService.deleteById(id), HttpStatus.OK);
    }

}