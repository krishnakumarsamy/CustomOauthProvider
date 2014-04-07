package org.springframework.security.oauth.sample.provider.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.examples.sparklr.oauth.SparklrConsumerDetails;

@SuppressWarnings("deprecation")
public class CustomerDAO {
	 
		public SparklrConsumerDetails searchDatabase(String username) {
			// Retrieve all users from the database
			List<SparklrConsumerDetails> users = internalDatabase();

			// Search user based on the parameters
			for(SparklrConsumerDetails dbUser:users) {
				if ( dbUser.getConsumerKey().equals(username)  == true ) {
					//logger.debug("User found");
					// return matching user
					return dbUser;
				}
			}

			//logger.error("User does not exist!");
			throw new RuntimeException("User does not exist!");
		}

		/**
		 * Our fake database. Here we populate an ArrayList with a dummy list of users.
		 */
		private List<SparklrConsumerDetails> internalDatabase() {
			// Dummy database

			// Create a dummy array list
			List<SparklrConsumerDetails> users = new ArrayList<SparklrConsumerDetails>();
			SparklrConsumerDetails user = null;

			// Create a new dummy user
			user = new SparklrConsumerDetails();
			user.setConsumerKey("krishnakumar");
			user.setAuthorities(getGrantedAuthority());
			user.setConsumerName("Krishnakumar");
			user.setDisplayName("Krishnakumar Murugasamy");
			user.setRequiredToObtainAuthenticatedToken(true);
			user.setSignatureSecret(new SharedConsumerSecretImpl("krishnakumar"));
			users.add(user);
			
			
//			user.setUsername("john");
//			// Actual password: admin
//			user.setPassword("21232f297a57a5a743894a0e4a801fc3");
//			// Admin user
//			user.setAccess(1);
//
//			// Add to array list
//			users.add(user);
//
//			// Create a new dummy user
//			user = new DbUser();
//			user.setUsername("jane");
//			// Actual password: user
//			user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
//			// Regular user
//			user.setAccess(2);
//
//			// Add to array list
//			users.add(user);

			return users;
		}

		@SuppressWarnings("deprecation")
		private List<GrantedAuthority> getGrantedAuthority() {
			List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
			authority.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			authority.add(new GrantedAuthorityImpl("ROLE_USER"));
			return authority;
		}

}
