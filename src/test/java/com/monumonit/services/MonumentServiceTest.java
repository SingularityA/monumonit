package com.monumonit.services;

import com.monumonit.config.AppConfig;
import com.monumonit.entities.Monument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class MonumentServiceTest {

    @Autowired
    private MonumentService service;

    @Test
    public void testFindAll() throws Exception {
        List<Monument> monuments = service.findAll();
        assertThat(monuments.size(), is(3));
    }

    @Test
    public void testFind() throws Exception {
        Monument monument = service.find(1L);
        assertThat(monument.getId(), is(1L));
        assertThat(monument.getName(), is("TestName1"));
        assertThat(monument.getComplexId(), is(1L));
        assertThat(monument.getPartMonumentId(), is(nullValue()));
    }

    @Test
    public void testSaveCreatesEntity() throws Exception {
        Monument monument = new Monument();
        monument.setName("TestName4");
        monument.setComplexId(1L);
        monument.setPartMonumentId(2L);

        service.save(monument);
        System.out.println(monument.getId());
        assertThat(monument.getId(), is(notNullValue()));

        Monument foundMonument = service.find(monument.getId());
        assertThat(foundMonument.getName(), is("TestName4"));
        assertThat(foundMonument.getComplexId(), is(1L));
        assertThat(foundMonument.getPartMonumentId(), is(2L));
    }

    @Test
    public void testSaveUpdatesEntity() throws Exception {
        Monument monument = service.find(1L);
        monument.setName("NameChanged");

        service.save(monument);
        Monument foundMonument = service.find(monument.getId());

        assertThat(foundMonument.getName(), is("NameChanged"));
    }

    @Test
    public void testDelete() throws Exception {
        for (Monument monument: service.findAll()) {
            service.delete(monument);
        }
        List<Monument> monuments = service.findAll();
        assertThat(monuments.size(), is(0));
    }
}
