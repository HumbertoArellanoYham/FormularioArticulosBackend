package com.coppeltestbackend.crud.services;

import com.coppeltestbackend.crud.models.Article;
import com.coppeltestbackend.crud.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServicesImpl implements ArticleServices<Article> {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServicesImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Article> findAll() {
        List<Article> result = new ArrayList<>();
        Iterator<Article> resultIterator = articleRepository.findAll().iterator();

        resultIterator.forEachRemaining(result::add);
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Article> findBySku(Integer sku) {
         return articleRepository.findById(sku);
    }

    @Transactional
    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Transactional()
    @Override
    public void remove(Integer sku) {
        articleRepository.deleteById(sku);
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> departamento() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> clase(String departamento) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> familia(String clase) {
        return null;
    }
}
