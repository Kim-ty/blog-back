package com.gabekim.domain.tag.repository;

import java.util.List;

import com.gabekim.entity.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
  
  String tagQuery = "select tag_name "+
                    "from tag "+
                    "where tag_name is not null "+
                    "group by tag_name "+
                    "order by count(tag_name) desc";


  @Query(value = tagQuery,nativeQuery = true)
  List<Tag> findGroupByTagWithJPQL();

  

}
