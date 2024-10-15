package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Article;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    @Procedure(procedureName = "DeleteArticleBySku")
    void deleteArticle(Integer sku);

    @Procedure(procedureName = "FindAllArticles")
    List<Article> findAllArticles();

    @Procedure(procedureName = "FindArticleBySku")
    Article findArticleBySku(Integer sku);

    @Procedure(procedureName = "SaveArticle")
    void saveArticle(Integer sku, String nombre, String marca,
                     String modelo, String departamento,
                     String clase, String familia, Date fecha_alta, Integer stock,
                     Integer cantidad, Integer descontinuado, Date fecha_baja);

    @Procedure(procedureName = "UpdateArticle")
    void UpdateArticle(Integer sku, String nombre, String marca,
                     String modelo, String departamento,
                     String clase, String familia, Date fecha_alta, Integer stock,
                     Integer cantidad, Integer descontinuado, Date fecha_baja);
}
