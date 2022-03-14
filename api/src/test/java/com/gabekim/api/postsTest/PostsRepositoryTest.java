package com.gabekim.api.postsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.gabekim.domain.posts.repository.PostsRepository;
import com.gabekim.domain.tag.repository.TagRepository;
import com.gabekim.entity.Posts;
import com.gabekim.entity.Tag;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PostsRepositoryTest {
   
  @Autowired 
  private PostsRepository postsRepository;

  @Autowired
  private TagRepository tagRepository;


  @Test //categoryList Test
  public void OrderByRegDateDescTest(){

    List<Posts> postsList = postsRepository.OrderByRegDateDesc();

    postsList.forEach(new Consumer<Posts>() {
      @Override
      public void accept(Posts t) {
        System.out.println(t.toString());
      }
      
    });
  }

  @Test //포스트 디테일 get
  public void findByPostsNo(){
    Optional<Posts> postDetail = postsRepository.findByPostsNo(1);


    System.out.println(postDetail.toString());

  }
  
  @Test
  public void postPosts(){

    String[] tagList = {"insert","test","repository"};

    Posts post = Posts.builder().title("insert").detail("insert test 본문입니다.").categoryNo(6).build();

    Posts resultPost = postsRepository.save(post);

    List<Tag> tagEntityList = new ArrayList<Tag>() {
      {
      for(String tag:tagList){
        Tag tagItem = Tag.builder().postsNo(resultPost.getPostsNo()).tagName(tag).build();
        add(tagItem);
      }
    }
    };
    

    List<Tag> tagResultList = tagRepository.saveAll(tagEntityList);


  }


}