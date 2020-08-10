package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequestMapping("/comments")
public class CommentsController implements Controller <Comment>{

    @Override
    public ResponseEntity<Page<Comment>> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Comment>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> save(Comment comment) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> update(Comment comment) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return null;
    }
}
