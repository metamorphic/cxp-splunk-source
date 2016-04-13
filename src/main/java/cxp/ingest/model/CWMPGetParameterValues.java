package cxp.ingest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by markmo on 14/04/2016.
 */
@XmlRootElement(namespace = "urn:dslforum-org:cwmp-1-0", name = "cwmp:GetParameterValues")
public class CWMPGetParameterValues {

    private List<String> parameterNames;

    @XmlElement(name = "string")
    @XmlElementWrapper(name = "ParameterNames")
    public List<String> getParameterNames() {
        return parameterNames;
    }

    public void setParameterNames(List<String> parameterNames) {
        this.parameterNames = parameterNames;
    }
}
