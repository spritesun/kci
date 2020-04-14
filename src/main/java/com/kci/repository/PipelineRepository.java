package com.kci.repository;

import com.kci.entity.Pipeline;
import com.kci.service.NotificationCenter;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

@Repository
public class PipelineRepository {
    @Autowired
    private NotificationCenter nc;
    @Autowired
    private Nitrite dataSource;

    public void save(Pipeline pipeline) {
        getObjectRepository().insert(pipeline);
        nc.notifyf("Pipeline %s created.", pipeline.getName());
    }

    public List<Pipeline> findAll() {
        return getObjectRepository().find().toList();
    }

    private ObjectRepository<Pipeline> getObjectRepository() {
        return dataSource.getRepository(Pipeline.class);
    }

    public Pipeline findByName(String name) {
        return getObjectRepository().find(eq("name", name)).firstOrDefault();
    }
}
