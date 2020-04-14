package com.kci.view;

import com.kci.entity.Build;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildListView {
    public String render(List<Build> builds) {
        StringBuilder builder = new StringBuilder();
        builder.append("Pipeline\tSequence\tSTATUS\n");
        for (Build build : builds) {
            builder.append(build.getPipelineName());
            builder.append("\t");
            builder.append(build.getSequence());
            builder.append("\t");
            builder.append("SUCCESS");
            builder.append("\n");
        }
        return builder.toString();
    }
}
