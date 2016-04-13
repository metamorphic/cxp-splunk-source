package cxp.ingest.util;

import cxp.ingest.model.Component;
import cxp.ingest.model.DeviceSummaries;
import cxp.ingest.model.DeviceSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markmo on 10/04/2016.
 */
public class DeviceSummaryParser {

    public DeviceSummaries parse(String input) {
        Pattern pattern = Pattern.compile("(\\w+):(\\d+\\.\\d+)\\[(\\d+)?\\]\\(((\\w+:\\d+(,\\s)?)*)\\)");
        DeviceSummaries summaries = new DeviceSummaries();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String name = matcher.group(1);
            String version = matcher.group(2);
            String compStr = matcher.group(4);
            String[] comps = compStr.split(", ");
            List<Component> components = new ArrayList<>();
            for (String comp : comps) {
                Component component = new Component();
                String[] parts = comp.split(":");
                component.setName(parts[0]);
                component.setStatus(Integer.parseInt(parts[1]));
                components.add(component);
            }
            DeviceSummary summary = new DeviceSummary();
            summary.setName(name);
            summary.setVersion(version);
            summary.setComponents(components);
            summaries.add(summary);
        }
        return summaries;
    }
}
