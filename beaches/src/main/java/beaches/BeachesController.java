/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beaches;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author slewis
 */
@RestController
public class BeachesController {
    @RequestMapping("/beaches")
    public Beach beaches(@RequestParam(value="id") int id) {
        return new Beach(id, "name", 100);
    }
}
