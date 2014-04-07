package org.springframework.security.oauth.sample.provider;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.examples.sparklr.oauth.SparklrConsumerDetails;
import org.springframework.security.oauth.sample.provider.DAO.CustomerDAO;

public class ProviderUserDetailsServiceImpl implements UserDetailsService {

	CustomerDAO dao = new CustomerDAO(); 

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		SparklrConsumerDetails consumerDetails = dao.searchDatabase(username);
		UserDetails user = null;
		user = new User(username, ((SharedConsumerSecretImpl)consumerDetails.getSignatureSecret()).getConsumerSecret(), true, true, true, true, consumerDetails.getAuthorities());
		return user;
	}

}
