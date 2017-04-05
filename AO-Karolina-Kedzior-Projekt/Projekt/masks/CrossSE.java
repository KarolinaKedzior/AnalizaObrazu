
package kimage.sample.masks;


public class CrossSE extends SE {
    
    public CrossSE(int SEsize) {
        super(SEsize); 
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                if(i == SEsize/2 || j == SEsize/2)    
                    mask[i][j] = 1;
                }
            }
    }
    
     public static void main(String [] args) {
        
        SE circle = new CrossSE(7);
        circle.println();
    }
}
