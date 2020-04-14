package com.kci.service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GitService {
    @Autowired
    private NotificationCenter nc;

    public void clone(String remoteUrl, String localPath) throws GitAPIException {
        Git.cloneRepository()
                .setURI(remoteUrl)
                .setDirectory(new File(localPath))
                .call();
        nc.notify(String.format("Downloaded %s to %s.", remoteUrl, localPath));
    }

    public void pull(String path) {
        // TODO
    }
}
