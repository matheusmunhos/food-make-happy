package br.com.munhosdev.food_make_happy.config;

import br.com.munhosdev.food_make_happy.domain.Doador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import jakarta.annotation.PostConstruct;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initIndexes() {
        mongoTemplate.indexOps(Doador.class).ensureIndex(new GeospatialIndex("localizacao").typed(GeoSpatialIndexType.GEO_2DSPHERE));
    }
}