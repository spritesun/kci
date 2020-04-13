package com.kci.view;

import com.kci.entity.Pipeline;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PipelineListView {
    public String render(List<Pipeline> pipelines) {
        StringBuilder builder = new StringBuilder();
        builder.append("Name\tUrl\tLAST_BUILD\tSTATUS\n");
        for (Pipeline pipeline : pipelines) {
            builder.append(pipeline.getName());
            builder.append("\t");
            builder.append(pipeline.getRepository().getUrl());
            builder.append("\t");
            builder.append("N\\A");
            builder.append("\t");
            builder.append("N\\A");
            builder.append("\n");
        }
        return builder.toString();
    }
}
