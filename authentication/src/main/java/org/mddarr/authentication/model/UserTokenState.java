package org.mddarr.authentication.model;

/**
 * Created by fan.jin on 2016-10-17.
 */
public class UserTokenState {
    private String token;
    private Long expires_in;
    public String name;
    public UserTokenState() {
        this.token = null;
        this.expires_in = null;
        this.name = null;
    }
    public UserTokenState(String token, long expires_in, String name) {
        this.token = token;
        this.expires_in = expires_in;
        this.name = name;
    }
    public String getName() {return name; }
    public void setName(String name) {
        this.name = name;
    }
    public String gettoken() {
        return token;
    }
    public void settoken(String token) {
        this.token = token;
    }
    public Long getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}