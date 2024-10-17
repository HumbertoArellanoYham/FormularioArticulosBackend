package com.coppeltestbackend.crud.controller;

import com.coppeltestbackend.crud.models.Article;
import com.coppeltestbackend.crud.services.ArticleServices;
import com.coppeltestbackend.crud.services.interfaces.ArticleInterface;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/articulo")
public class ArticuloController {
    @Autowired
    private ArticleServices articleServices;

    @GetMapping(value = "/{sku}")
    public ResponseEntity<Article> articleBySku(@PathVariable(name = "sku") Integer sku){
        Optional<Article> article = articleServices.findBySku(sku);

        return article.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    @GetMapping(value = "/allArticles")
    public List<Article> allArticles(){
        return articleServices.findAll();
    }

    @PostMapping(value = "/saveArticle")
    public ResponseEntity<?> saveArticle(@RequestBody Article article){
        articleServices.save(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updateArticle")
    public ResponseEntity<?> updateArticle(@RequestBody Article article){
        articleServices.update(article);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
