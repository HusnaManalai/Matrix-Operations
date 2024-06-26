
public class MatrixOperations {

    //add matrecies 
    public static Matrix add (Matrix a, Matrix b){
        int size = a.getSize();
        Matrix result = new Matrix(size);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                result.setValue(i, j, a.getValue(i, j) + b.getValue(i,j));
            }
        }
        return result;
    }


    //subtract
    public static Matrix subtract (Matrix a, Matrix b){
        int size = a.getSize();
        Matrix result = new Matrix(size);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                result.setValue(i, j, a.getValue(i, j) - b.getValue(i,j));
            }
        }
        return result;
    }

    //multiply
   public static Matrix multiply(Matrix a, Matrix b) {
        int size = a.getSize();
        Matrix result = new Matrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += a.getValue(i, k) * b.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }


}
