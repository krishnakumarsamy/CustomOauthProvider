package org.springframework.security.oauth.examples.providerdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsDAO {

    /**
     * Used to find the user using username
     * 
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetailsBean findUser(String userName) throws UsernameNotFoundException {
        List<UserDetailsBean> providerUsers = getAllProviderDetails();
        for (UserDetailsBean user : providerUsers) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("UserNotFound");
    }

    /**
     * Sample List of user details, we can implement our own database connectivity
     * 
     * @return List<UserDetailsBean>
     * 
     */
    public List<UserDetailsBean> getAllProviderDetails() {
        List<UserDetailsBean> list = new ArrayList<UserDetailsBean>();
        UserDetailsBean user1 = new UserDetailsBean();
        user1.setUserName("SparklrKrishnakumar");
        user1.setPassword("SparklrKrishnakumar");
        user1.setAuthority(getGrantedAuthority());
        user1.setAccountNotExpired(true);
        user1.setAccountNotLocked(true);
        user1.setCredentialsNotExpired(true);
        user1.setEnabled(true);
        list.add(user1);
        return list;
    }

    /**
     * Used to get the role list
     * 
     * @return List<GrantedAuthority>
     */
    @SuppressWarnings("deprecation")
    private List<GrantedAuthority> getGrantedAuthority() {
        List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
        authority.add(new GrantedAuthorityImpl("ROLE_USER"));
        return authority;
    }
}
