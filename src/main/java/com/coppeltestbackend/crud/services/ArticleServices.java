package com.coppeltestbackend.crud.services;

import com.coppeltestbackend.crud.models.Article;
import com.coppeltestbackend.crud.repositories.ArticleRepository;
import com.coppeltestbackend.crud.services.interfaces.ArticleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@EnableCaching
@Service
public class ArticleServices implements ArticleInterface<Article> {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServices(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Cacheable(value = "findAll")
    @Transactional(readOnly = true)
    @Override
    public List<Article> findAll() {
        List<Article> result = new ArrayList<>();
        Iterator<Article> resultIterator = articleRepository.findAllArticles().iterator();

        resultIterator.forEachRemaining(result::add);
        return result;
    }

    @Cacheable(value = "findBySku")
    @Transactional(readOnly = true)
    @Override
    public Optional<Article> findBySku(Integer sku) {
         return articleRepository.findArticleBySku(sku);
    }

    @Transactional
    @Override
    public void save(Article article) {
       articleRepository.save(article);
    }

    @Transactional
    @Override
    public void update(Article article) {
        Optional<Article> articleSearch = articleRepository.findArticleBySku(article.getSku());
        Article newArticle = articleSearch.orElseGet(Article::new);

            newArticle.setNombre(article.getNombre());
            newArticle.setMarca(article.getMarca());
            newArticle.setModelo(article.getModelo());
            newArticle.setDepartamento(article.getDepartamento());
            newArticle.setClase(article.getClase());
            newArticle.setFamilia(article.getFamilia());
            newArticle.setFecha_alta(article.getFecha_alta());
            newArticle.setStock(article.getStock());
            newArticle.setCantidad(article.getCantidad());
            newArticle.setDescontinuado(article.getDescontinuado());
            newArticle.setFecha_baja(article.getFecha_baja());

            articleRepository.save(newArticle);
    }

    @Transactional()
    @Override
    public void remove(Integer sku) {
        articleRepository.deleteArticle(sku);
    }
}
