package org.testing.framework.injectors;

import org.testing.framework.Setup;

public class Initialisation {
    public Initialisation(World world){
      world.setup = new Setup();
    }
}