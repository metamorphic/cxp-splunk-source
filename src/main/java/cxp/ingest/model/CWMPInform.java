package cxp.ingest.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by markmo on 9/04/2016.
 */
@XmlRootElement(namespace = "urn:dslforum-org:cwmp-1-2", name = "Inform")
public class CWMPInform {

    private DeviceId deviceId;
    private List<Event> events;
    private int maxEnvelopes;
    private Date currentTime;
    private int retryCount;
    private List<ParameterValue> parameterValues;

    @XmlElement(name = "DeviceId")
    public DeviceId getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(DeviceId deviceId) {
        this.deviceId = deviceId;
    }

    @XmlElement(name = "EventStruct")
    @XmlElementWrapper(name = "Event")
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @XmlElement(name = "MaxEnvelopes")
    public int getMaxEnvelopes() {
        return maxEnvelopes;
    }

    public void setMaxEnvelopes(int maxEnvelopes) {
        this.maxEnvelopes = maxEnvelopes;
    }

    @XmlElement(name = "CurrentTime")
    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    @XmlElement(name = "RetryCount")
    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @XmlElement(name = "ParameterValueStruct")
    @XmlElementWrapper(name = "ParameterList")
    public List<ParameterValue> getParameterValues() {
        return parameterValues;
    }

    public void setParameterValues(List<ParameterValue> parameterValues) {
        this.parameterValues = parameterValues;
    }

    public String getParameterValue(final String name) {
        if (name == null) return null;
        if (parameterValues == null || parameterValues.isEmpty()) return null;
        Iterator<ParameterValue> filtered = Iterables.filter(parameterValues, new Predicate<ParameterValue>() {
            @Override
            public boolean apply(@Nullable ParameterValue input) {
                return input != null && name.equals(input.getName());
            }
        }).iterator();
        if (filtered.hasNext()) {
            return filtered.next().getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        return "CWMPInform{" +
                "deviceId=" + deviceId +
                ", events=" + events +
                ", maxEnvelopes=" + maxEnvelopes +
                ", currentTime=" + currentTime +
                ", retryCount=" + retryCount +
                ", parameterValues=" + parameterValues +
                '}';
    }
}
