
package kimage.sample.masks;

import kimage.sample.masks.SE;


public class SquareSE extends SE {
    
    public SquareSE(int SEsize) {
        super(SEsize); 
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                    mask[i][j] = 1;
                }
            }
    }
    
}
