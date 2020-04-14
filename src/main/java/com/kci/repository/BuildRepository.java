package com.kci.repository;

import com.kci.entity.Build;
import com.kci.service.NotificationCenter;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

@Repository
public class BuildRepository {
    @Autowired
    private NotificationCenter nc;
    @Autowired
    private Nitrite dataSource;

    public void save(Build build) {
        build.setSequence(findNextSequence(build.getPipelineName()));
        getObjectRepository().insert(build);
        nc.notifyf("Build %s-%d finished.", build.getPipelineName(), build.getSequence());
    }

    public List<Build> findAll() {
        return getObjectRepository().find().toList();
    }

    private int findNextSequence(String pipelineName) {
        List<Build> builds = getObjectRepository().find(eq("pipelineName", pipelineName)).toList();
        if (builds.isEmpty()) {
            return 1;
        }
        return builds.stream().mapToInt(Build::getSequence).max().getAsInt() + 1;
    }

    private ObjectRepository<Build> getObjectRepository() {
        return dataSource.getRepository(Build.class);
    }
}
