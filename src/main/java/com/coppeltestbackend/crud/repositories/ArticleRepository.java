package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    @Query(value = "call DeleteArticleBySku(:a_sku)", nativeQuery = true)
    void deleteArticle(@Param("a_sku") Integer a_sku);

    @Query(value = "call FindAllArticles()", nativeQuery = true)
    List<Article> findAllArticles();

    @Query(value = "call FindArticleBySku(:a_sku)", nativeQuery = true)
    Optional<Article> findArticleBySku(@Param(value = "a_sku")Integer a_sku);
}
