package com.gabekim.domain.posts.repository;

import java.util.List;
import java.util.Optional;

import com.gabekim.entity.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {
  
  //게시물 리스트
  List<Posts> OrderByRegDateDesc();

  //게시글
  Optional<Posts> findByPostsNo(int postsNo);

}
