package com.pows.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TargetSystem {
    private String system_code;
    private String getSystem_name;

    public String getSystem_code() {
        return system_code;
    }

    public void setSystem_code(String system_code) {
        this.system_code = system_code;
    }

    public String getGetSystem_name() {
        return getSystem_name;
    }

    public void setGetSystem_name(String getSystem_name) {
        this.getSystem_name = getSystem_name;
    }
}
