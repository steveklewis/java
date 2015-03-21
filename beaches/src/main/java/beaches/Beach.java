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
    public int id;
    public String name;
    public float score;
    
    public Beach(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
