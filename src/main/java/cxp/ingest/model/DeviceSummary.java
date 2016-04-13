package cxp.ingest.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by markmo on 10/04/2016.
 */
public class DeviceSummary {

    private String name;
    private String version;
    private List<Component> components = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Component getComponent(final String name) {
        if (name == null) return null;
        if (components == null || components.isEmpty()) return null;
        Iterator<Component> filtered = Iterables.filter(components, new Predicate<Component>() {
            @Override
            public boolean apply(@Nullable Component input) {
                return input != null && name.equals(input.getName());
            }
        }).iterator();
        if (filtered.hasNext()) {
            return filtered.next();
        }
        return null;
    }
}
