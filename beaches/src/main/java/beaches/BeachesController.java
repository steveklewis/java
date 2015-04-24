/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beaches;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author slewis
 */
@RestController
@RequestMapping("/beaches")
public class BeachesController {
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> beaches(@RequestBody Beach input) {
        
        Beach newBeach = input;
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(newBeach.id).toUri());
        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                newBeach, httpHeaders, HttpStatus.CREATED);
        
        return responseEntity;
    }
}
