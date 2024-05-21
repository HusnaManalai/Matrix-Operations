import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatrixCalculator extends JFrame {
    private JTextField sizeField;
    private JPanel matrixAPanel, matrixBPanel;
    private JTextField[][] matrixAInputs, matrixBInputs;
    private JButton addButton, subtractButton, multiplyButton;
    private JTextArea resultArea;
    private int matrixSize;

    public MatrixCalculator() {
        setTitle("Matrix Calculator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for matrix size input
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new FlowLayout());
        sizePanel.add(new JLabel("Matrix Size:"));
        sizeField = new JTextField(5);
        sizePanel.add(sizeField);
        JButton setSizeButton = new JButton("Set Size");
        sizePanel.add(setSizeButton);
        add(sizePanel, BorderLayout.NORTH);

        // Center panel for matrix inputs
        JPanel matricesPanel = new JPanel();
        matricesPanel.setLayout(new GridLayout(1, 2));

        matrixAPanel = new JPanel();
        matrixBPanel = new JPanel();

        matricesPanel.add(new JScrollPane(matrixAPanel));
        matricesPanel.add(new JScrollPane(matrixBPanel));

        add(matricesPanel, BorderLayout.CENTER);

        // Bottom panel for buttons and result display
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // Action listeners
        setSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrixSize = Integer.parseInt(sizeField.getText());
                createMatrixInputs();
            }
        });

        addButton.addActionListener(new OperationListener());
        subtractButton.addActionListener(new OperationListener());
        multiplyButton.addActionListener(new OperationListener());
    }

    private void createMatrixInputs() {
        matrixAPanel.removeAll();
        matrixBPanel.removeAll();

        matrixAPanel.setLayout(new GridLayout(matrixSize, matrixSize));
        matrixBPanel.setLayout(new GridLayout(matrixSize, matrixSize));

        matrixAInputs = new JTextField[matrixSize][matrixSize];
        matrixBInputs = new JTextField[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrixAInputs[i][j] = new JTextField(5);
                matrixAPanel.add(matrixAInputs[i][j]);

                matrixBInputs[i][j] = new JTextField(5);
                matrixBPanel.add(matrixBInputs[i][j]);
            }
        }

        matrixAPanel.revalidate();
        matrixAPanel.repaint();
        matrixBPanel.revalidate();
        matrixBPanel.repaint();
    }

    private class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Matrix a = readMatrix(matrixAInputs, matrixSize);
            Matrix b = readMatrix(matrixBInputs, matrixSize);

            Matrix result;
            if (e.getSource() == addButton) {
                result = MatrixOperations.add(a, b);
            } else if (e.getSource() == subtractButton) {
                result = MatrixOperations.subtract(a, b);
            } else {
                result = MatrixOperations.multiply(a, b);
            }

            resultArea.setText(result.toString());
        }

        private Matrix readMatrix(JTextField[][] inputs, int size) {
            Matrix matrix = new Matrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix.setValue(i, j, Integer.parseInt(inputs[i][j].getText()));
                }
            }
            return matrix;
        }
    }

    public static void main(String[] args) {
        MatrixCalculator calculator = new MatrixCalculator();
        calculator.setVisible(true);
    }
}
