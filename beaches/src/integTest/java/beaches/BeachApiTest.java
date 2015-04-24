/*
 * Copyright (c) 2015 slewis.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    slewis - initial API and implementation and/or initial documentation
 */
package beaches;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 * @author slewis
 */
public class BeachApiTest {

    @Test
    public void testRequiresLogin() {
        Assert.fail();
    }
    
    @Test
    public void testPostAddsLocationHeader() {
        Assert.fail();
    }
    
    @Test
    public void testGet() {
        
        String host = "127.0.0.1";
        int port = 8080;
        String username = "admin";
        String password = "admin";
        
        RestTemplate template = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes(Charset.forName("US-ASCII")))));
       
        Beach beach = new Beach(0, "St. Petersburg", new Float(90));
        
        HttpEntity<Beach> beachEntity = new HttpEntity<>(beach, headers);

        String url = String.format("http://%s:%d/beaches/", host, port);
        
        ResponseEntity<Beach> postedBeach = template.exchange(
                url,
                HttpMethod.POST,
                beachEntity,
                Beach.class);

        Assert.assertNotSame(0, postedBeach.getBody().id);
        Assert.assertNotNull(postedBeach.getHeaders().get("Location"));
    }
}
