/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public void testGet() {
        
        String host = "127.0.0.1";
        int port = 8000;
        String username = "admin";
        String password = "admin";
        
        RestTemplate template = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes(Charset.forName("US-ASCII")))));
        HttpEntity<byte[]> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = template.exchange("http://127.0.0.1:8000/beaches/", HttpMethod.valueOf("GET"), entity, byte[].class);
        
        Beach beach = new Beach(0, "St. Petersburg", new Float(90));
        
        HttpEntity<Beach> beachEntity = new HttpEntity<>(beach, headers);

        ResponseEntity<Beach> postedBeach = template.exchange(
                "http://127.0.0.1:8000/beaches/",
                HttpMethod.POST,
                beachEntity,
                Beach.class);

        Assert.assertNotSame(0, postedBeach.getBody().id);
    }
}
