package com.kci.repository;

import com.kci.entity.Pipeline;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PipelineRepository {
    @Autowired
    private Nitrite dataSource;

    public void save(Pipeline pipeline) {
        getObjectRepository().insert(pipeline);
        System.out.println(String.format("Pipeline %s created.", pipeline.getName()));
    }

    public List<Pipeline> findAll() {
        return getObjectRepository().find().toList();
    }

    private ObjectRepository<Pipeline> getObjectRepository() {
        return dataSource.getRepository(Pipeline.class);
    }
}
