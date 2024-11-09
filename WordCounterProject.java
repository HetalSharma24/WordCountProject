import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class WordCounterProject {
    public static void main(String[] args) {
        // Create a new frame (window)
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        
        // Create custom panel with a gradient background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Create a gradient from top-left to bottom-right
                Color color1 = new Color(255, 153, 204);  
                Color color2 = new Color(102, 204, 255);  
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());

        // Create text area for paragraph input
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));  // Set font for the text area
        
        // Add rounded border and padding to the text area
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.WHITE, 3, true),  // Rounded white border
            new EmptyBorder(10, 10, 10, 10)        // Padding inside
        ));
        textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create a label to display the count
        JLabel wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setFont(new Font("Serif", Font.BOLD, 18));  // Set font for the label
        wordCountLabel.setForeground(Color.DARK_GRAY);  // Set text color for the label
        wordCountLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create a button to trigger the count action with an icon
        JButton countButton = new JButton("Count Words");
        countButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        countButton.setForeground(Color.WHITE);
        countButton.setBackground(new Color(0, 128, 128));  // Teal background
        countButton.setOpaque(true);
        countButton.setBorderPainted(false);
        
        // Add rounded border to the button
        countButton.setBorder(new LineBorder(Color.WHITE, 2, true));
        
        // Set button hover effect
        countButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                countButton.setBackground(new Color(0, 153, 153));  // Darker teal when hovered
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                countButton.setBackground(new Color(0, 128, 128));  // Original color when not hovered
            }
        });

        // Action listener for the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textArea.getText().trim();
                if (!inputText.isEmpty()) {
                    String[] words = inputText.split("\\s+");  // Split by whitespace
                    wordCountLabel.setText("Word Count: " + words.length);
                } else {
                    wordCountLabel.setText("Word Count: 0");
                }
            }
        });

        // Add a decorative title label at the top
        JLabel titleLabel = new JLabel("Welcome to Word Counter!", JLabel.CENTER);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);  // White text
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));  // Padding around the label
        
        // Add components to the panel
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(textPanel, BorderLayout.CENTER);
        
        // Panel for the button and word count label
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);  // Make it transparent to see the gradient background
        bottomPanel.add(wordCountLabel, BorderLayout.NORTH);
        bottomPanel.add(countButton, BorderLayout.SOUTH);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
