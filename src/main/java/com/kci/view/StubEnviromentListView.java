package com.kci.view;

import org.springframework.stereotype.Component;

@Component
public class StubEnviromentListView {
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name\n");
        builder.append("Dev\n");
        builder.append("Staging\n");
        builder.append("Prod\n");
        return builder.toString();
    }
}
