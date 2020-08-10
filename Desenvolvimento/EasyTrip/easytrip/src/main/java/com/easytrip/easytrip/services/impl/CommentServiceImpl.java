package com.easytrip.easytrip.services.impl;


import com.easytrip.easytrip.controllers.impl.CommentsController;
import com.easytrip.easytrip.models.Comment;
import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.repository.CommentRepository;
import com.easytrip.easytrip.repository.ItineraryRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements Services<Comment> {

    CommentRepository commentRepository;


    @Override
    public Page findAll(Pageable pageable, String searchText) {
        return commentRepository.findAllComments(pageable, searchText);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment saveOrUpdate(Comment comment) {

        return commentRepository.save(comment);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            commentRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
