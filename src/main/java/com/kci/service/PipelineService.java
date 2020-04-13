package com.kci.service;

import com.kci.entity.Pipeline;
import com.kci.entity.Repository;
import com.kci.repository.PipelineRepository;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PipelineService {

    @Autowired
    private GitService gitService;

    @Autowired
    private PipelineRepository pipelineRepository;

    public void create(String name, String url) throws GitAPIException, IOException {
        Repository repository = new Repository(url);
        gitService.clone(url, repository.getAbsolutePath());

        Pipeline pipeline = new Pipeline(name, repository);
        pipelineRepository.save(pipeline);
    }

    public List<Pipeline> getPipelines() {
        return pipelineRepository.findAll();
    }
}
