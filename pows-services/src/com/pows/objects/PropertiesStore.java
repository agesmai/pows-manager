package com.pows.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PropertiesStore {
    private String system_code;
    private String prop_name;
    private int is_encrypt;
    private long last_modify;

    public String getSystem_code() {
        return system_code;
    }

    public void setSystem_code(String system_code) {
        this.system_code = system_code;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public int getIs_encrypt() {
        return is_encrypt;
    }

    public void setIs_encrypt(int is_encrypt) {
        this.is_encrypt = is_encrypt;
    }

    public long getLast_modify() {
        return last_modify;
    }

    public void setLast_modify(long last_modify) {
        this.last_modify = last_modify;
    }
}
