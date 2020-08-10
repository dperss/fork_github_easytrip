package com.easytrip.easytrip.repository;


import com.easytrip.easytrip.models.Comment;
import com.easytrip.easytrip.models.Itinerary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("FROM Comment b WHERE b.classification LIKE %:searchText% ")
    Page<Comment> findAllComments(Pageable pageable, @Param("searchText") String searchText);
}
