package com.kci.service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GitService {
    public void clone(String url, String directory) throws GitAPIException {
        Git.cloneRepository()
                .setURI(url)
                .setDirectory(new File(directory))
                .call();
        System.out.println(String.format("Downloaded %s to %s.", url, directory));
    }
}
