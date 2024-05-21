
public class Matrix{
	
	private int size;
	private int [][] data;
	
	public Matrix(int size) {
		this.size = size;
		data = new int[size][size];	
	}
	
	
	public void setValue(int row, int col, int value) {
		data[row][col] = value;		
	}
	
	
	public int getValue(int row, int col) {
		
		return data[row][col];
	}
	
	public int getSize() {
		return size;
		
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				sb.append(data[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}