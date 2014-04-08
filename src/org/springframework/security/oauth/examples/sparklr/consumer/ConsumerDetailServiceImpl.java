package org.springframework.security.oauth.examples.sparklr.consumer;

import org.springframework.security.oauth.common.OAuthException;
import org.springframework.security.oauth.examples.sparklr.consumerdao.CustomerDAO;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetailsService;

public class ConsumerDetailServiceImpl implements ConsumerDetailsService {

    CustomerDAO dao = new CustomerDAO();

    /**
     * Used to get the consumer details using consumer id (non-Javadoc) called from OAuthProviderProcessingFilter
     * 
     * @see org.springframework.security.oauth.provider.ConsumerDetailsService#loadConsumerByConsumerKey(java.lang.String)
     */
    @Override
    public ConsumerDetails loadConsumerByConsumerKey(String username) throws OAuthException {
        SparklrConsumerDetails consumerDetails = dao.searchDatabase(username);
        return consumerDetails;
    }

}
