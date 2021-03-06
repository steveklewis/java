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
