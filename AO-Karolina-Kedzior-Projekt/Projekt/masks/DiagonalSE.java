
package kimage.sample.masks;


public class DiagonalSE extends SE {
    
    public DiagonalSE(int SEsize) {
        super(SEsize);
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                if( i ==j)
                    mask[i][j] = 1;
    }}
    }
    public static void main(String [] args) {
        
        SE diag = new DiagonalSE(9);
        diag.println();
        diag.rotate();
        diag.println();
        
    }
}
