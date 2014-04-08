package org.springframework.security.oauth.examples.providerdao;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * Bean is used to get and set the user specific details
 * 
 */
public class UserDetailsBean {
    private String userName;
    private String password;
    private List<GrantedAuthority> authority;
    private boolean enabled, accountNotExpired, credentialsNotExpired, accountNotLocked;

    public String getUserName() {
        return userName;
    }

    /**
     * Set the user name this can be user id also
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Used to set credentials
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getAuthority() {
        return authority;
    }

    /**
     * Used to set roles
     * 
     * @param authority
     */
    public void setAuthority(List<GrantedAuthority> authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Used to set user is active/inactive state
     * 
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNotExpired() {
        return accountNotExpired;
    }

    /**
     * Used to set uset account expiry details
     * 
     * @param accountNotExpired
     */
    public void setAccountNotExpired(boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public boolean isCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    /**
     * Used to set password expiry details
     * 
     * @param credentialsNotExpired
     */
    public void setCredentialsNotExpired(boolean credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
    }

    public boolean isAccountNotLocked() {
        return accountNotLocked;
    }

    /**
     * Used to set whether the account is locked
     * 
     * @param accountNotLocked
     */
    public void setAccountNotLocked(boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

}
