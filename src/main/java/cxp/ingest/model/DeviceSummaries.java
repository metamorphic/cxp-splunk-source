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
public class DeviceSummaries {

    private List<DeviceSummary> summaries = new ArrayList<>();

    public List<DeviceSummary> get() {
        return summaries;
    }

    public void set(List<DeviceSummary> summaries) {
        this.summaries = summaries;
    }

    public void add(DeviceSummary summary) {
        summaries.add(summary);
    }

    public DeviceSummary getSummary(final String name) {
        if (name == null) return null;
        if (summaries == null || summaries.isEmpty()) return null;
        Iterator<DeviceSummary> filtered = Iterables.filter(summaries, new Predicate<DeviceSummary>() {
            @Override
            public boolean apply(@Nullable DeviceSummary input) {
                return input != null && name.equals(input.getName());
            }
        }).iterator();
        if (filtered.hasNext()) {
            return filtered.next();
        }
        return null;
    }
}
