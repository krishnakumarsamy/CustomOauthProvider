package org.springframework.security.oauth.examples.sparklr.consumerdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.examples.sparklr.consumer.SparklrConsumerDetails;

@SuppressWarnings("deprecation")
public class CustomerDAO {

    /**
     * Used to search consumer details using consumer name
     * 
     * @param username
     * @return
     */
    public SparklrConsumerDetails searchDatabase(String username) {
        // Retrieve all users from the database
        List<SparklrConsumerDetails> users = internalDatabase();
        // Search user based on the parameters
        for (SparklrConsumerDetails dbUser : users) {
            if (dbUser.getConsumerKey().equals(username) == true) {
                // return matching user
                return dbUser;
            }
        }
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
        user.setConsumerKey("krishnakumar-sample.com");
        user.setAuthorities(getGrantedAuthority());
        user.setConsumerName("krishnakumar-sample.com");
        user.setDisplayName("KrishnakumarMurugasamy");
        user.setRequiredToObtainAuthenticatedToken(true);
        user.setSignatureSecret(new SharedConsumerSecretImpl("krishnakumar"));
        users.add(user);
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
