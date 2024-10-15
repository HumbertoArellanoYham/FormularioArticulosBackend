package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
