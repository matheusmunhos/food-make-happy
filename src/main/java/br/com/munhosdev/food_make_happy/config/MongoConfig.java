package br.com.munhosdev.food_make_happy.config;

import br.com.munhosdev.food_make_happy.domain.Doador;
import br.com.munhosdev.food_make_happy.domain.Receptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import jakarta.annotation.PostConstruct;

@Configuration
public class MongoConfig {

    private final MongoTemplate mongoTemplate;

    public MongoConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void initIndexes() {
        mongoTemplate.indexOps(Doador.class).ensureIndex(new GeospatialIndex("localizacao").typed(GeoSpatialIndexType.GEO_2DSPHERE));
        mongoTemplate.indexOps(Receptor.class).ensureIndex(new GeospatialIndex("localizacao").typed(GeoSpatialIndexType.GEO_2DSPHERE));
    }
}
