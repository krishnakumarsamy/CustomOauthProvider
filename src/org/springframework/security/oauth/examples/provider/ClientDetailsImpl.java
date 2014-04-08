package org.springframework.security.oauth.examples.provider;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth.examples.providerdao.UserDetailsBean;
import org.springframework.security.oauth.examples.providerdao.UserDetailsDAO;

public class ClientDetailsImpl implements UserDetailsService {

    UserDetailsDAO dao = new UserDetailsDAO();

    /**
     * Used to validate user id and credentials (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsBean provideruser = dao.findUser(username);
        UserDetails user = null;
        user = new User(username, provideruser.getPassword(), provideruser.isEnabled(), provideruser.isAccountNotExpired(), provideruser.isCredentialsNotExpired(), provideruser.isAccountNotLocked(), provideruser.getAuthority());
        return user;
    }

}
