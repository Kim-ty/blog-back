package com.gabekim.domain.category.repository;

import java.util.List;

import com.gabekim.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

  List<Category> OrderByCategoryOrderAsc();

}
