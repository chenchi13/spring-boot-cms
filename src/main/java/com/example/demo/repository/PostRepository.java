package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Page;
import com.example.demo.model.Post;

@Component
public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByPage(Page page);

}
