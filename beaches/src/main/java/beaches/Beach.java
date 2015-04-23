/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beaches;

/**
 *
 * @author slewis
 */
public class Beach {
    public Integer id;
    public String name;
    public Float score;
    
    public Beach() {}
    
    public Beach(Integer id, String name, Float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
