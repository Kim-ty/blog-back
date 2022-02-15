package com.gabekim.api;

import java.util.List;
import java.util.function.Consumer;

import com.gabekim.domain.category.repository.CategoryRepository;
import com.gabekim.entity.Category;

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
public class CategoryRepositoryTest {
  
  @Autowired 
  private CategoryRepository categoryRepository;

  @Test //categoryList Test
  public void orderByCategoryNoAscTest(){

    List<Category> categoryList = categoryRepository.OrderByCategoryOrderAsc();

    categoryList.forEach(new Consumer<Category>() {
      @Override
      public void accept(Category t) {
        System.out.println(t.getCategoryName());
      }
      
    });
  }
}
