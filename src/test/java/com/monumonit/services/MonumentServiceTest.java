package com.monumonit.services;

import com.monumonit.entities.Complex;
import com.monumonit.entities.Monument;
import com.monumonit.entities.MonumentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class MonumentServiceTest {

    @Autowired
    private MonumentService monumentService;

    @Autowired
    private MonumentTypeService monumentTypeService;

    @Autowired
    private ComplexService complexService;

    private Logger logger = LoggerFactory.getLogger(MonumentService.class);

    @Test
    public void testFindAll() throws Exception {
        logger.info("FIND ALL ENTITIES");
        List<Monument> monuments = monumentService.findAll();

        logger.info("CHECKS");
        assertThat(monuments.size(), is(4));
    }

    @Test
    public void testFind() throws Exception {
        logger.info("FIND ENTITY");
        Monument monument = monumentService.find(1L);

        logger.info("FIND RELATIONS");
        MonumentType monumentType = monument.getMonumentType();
        Complex complex = monument.getComplex();
        Monument parent = monument.getParent();
        List<Monument> children = monument.getChildren();

        logger.info("CHECKS");
        assertThat(monument.getId(), is(1L));
        assertThat(monument.getName(), is("Эрмитажная аллея"));
        assertThat(monument.getDescription(),
                is("Аллея, соединяющая Екатерининский дворец с Эрмитажем. " +
                        "Вдоль нее установлены скульптуры героев античной мифологии"));

        assertThat(monumentType.getId(), is(3));
        assertThat(monumentType.getName(), is("Ансамбль"));

        assertThat(complex.getId(), is(2L));
        assertThat(complex.getName(), is("Екатерининский парк"));

        assertThat(parent, is(nullValue()));

        assertThat(children.size(), is(2));
        assertThat(children.get(0).getName(), is("Галатея"));
        assertThat(children.get(1).getName(), is("Геракл"));

    }

    @Test
    public void testSaveCreatesEntity() throws Exception {
        logger.info("RELATIVE ENTITIES");
        MonumentType monumentType = monumentTypeService.find(1);
        Complex complex = complexService.find(1L);
        Monument parent = monumentService.find(1L);

        logger.info("CREATE NEW MONUMENT");
        Monument monument = new Monument();
        monument.setName("TestName");
        monument.setMonumentType(monumentType);
        monument.setDescription("TestDescription");
        monument.setComplex(complex);
        monument.setParent(parent);
        monument.setChildren(new ArrayList<>());

        logger.info("SAVE BEGINS");
        monumentService.save(monument);
        Monument foundMonument = monumentService.find(monument.getId());

        logger.info("CHECKS");
        assertThat(foundMonument.getId(), is(monument.getId()));
        assertThat(foundMonument.getName(), is(monument.getName()));
        assertThat(foundMonument.getMonumentType(), is(monumentType));
        assertThat(foundMonument.getDescription(), is(monument.getDescription()));
        assertThat(foundMonument.getComplex(), is(complex));
        assertThat(foundMonument.getParent(), is(parent));
        assertThat(foundMonument.getChildren(), is(emptyCollectionOf(Monument.class)));
    }

    @Test
    public void testSaveUpdatesEntity() throws Exception {
        logger.info("RELATIVE ENTITIES");
        MonumentType monumentType = monumentTypeService.find(1);
        Complex complex = complexService.find(1L);
        Monument parent = monumentService.find(4L);

        logger.info("FIND MONUMENT AND CHANGE VALUES");
        Monument monument = monumentService.find(1L);
        monument.setName("TestName");
        monument.setMonumentType(monumentType);
        monument.setDescription("TestDescription");
        monument.setComplex(complex);
        monument.setParent(parent);
        monument.transferChildrenTo(null);

        logger.info("SAVE BEGINS");
        monumentService.save(monument);
        Monument foundMonument = monumentService.find(monument.getId());

        logger.info("CHECKS");
        assertThat(foundMonument.getId(), is(monument.getId()));
        assertThat(foundMonument.getName(), is(monument.getName()));
        assertThat(foundMonument.getMonumentType(), is(monumentType));
        assertThat(foundMonument.getDescription(), is(monument.getDescription()));
        assertThat(foundMonument.getComplex(), is(complex));
        assertThat(foundMonument.getParent(), is(parent));
        assertThat(foundMonument.getChildren(), is(emptyCollectionOf(Monument.class)));
    }

    @Test
    public void testDelete() throws Exception {
        logger.info("FIND ENTITY WITH CHILDREN");
        Monument monument = monumentService.find(1L);
        Monument parent = monument.getParent();
        List<Long> childrenIds = monument.getChildren().stream()
                .map(Monument::getId)
                .collect(Collectors.toList());

        logger.info("DELETE BEGINS");
        monumentService.delete(monument);

        logger.info("FIND CHILDREN AGAIN");
        Monument child1 = monumentService.find(3L);
        Monument child2 = monumentService.find(4L);

        logger.info("CHECKS");
        assertThat(monumentService.find(1L), is(nullValue()));
        assertThat(child1, is(notNullValue()));
        assertThat(child2, is(notNullValue()));

        assertThat(child1.getParent(), is(parent));
        assertThat(child2.getParent(), is(parent));
    }

    @Test
    public void testDeleteWithChildren() throws Exception {
        logger.info("FIND ENTITY WITH CHILDREN");
        Monument monument = monumentService.find(1L);

        logger.info("DELETE BEGINS");
        monumentService.deleteWithChildren(monument);

        logger.info("CHECKS");
        assertThat(monumentService.find(1L), is(nullValue()));
        assertThat(monumentService.find(3L), is(nullValue()));
        assertThat(monumentService.find(4L), is(nullValue()));
    }
}
