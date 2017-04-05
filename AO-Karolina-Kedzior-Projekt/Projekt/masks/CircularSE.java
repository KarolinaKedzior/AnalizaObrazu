
package kimage.sample.masks;

public class CircularSE extends SE{
    
    public CircularSE(int SEsize) {
        super(SEsize);
        int startX = super.getSize()/2;
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                if( (Math.pow(i-startX, 2) + Math.pow(j-startX, 2)) <= startX*startX)
                    mask[i][j] = 1;
                else{
                    mask[i][j] = -1;
                }
            }
        }
    }
    
    
    
    public static void main(String [] args) {
        
        SE circle = new CircularSE(7);
        circle.println();
    }
}
