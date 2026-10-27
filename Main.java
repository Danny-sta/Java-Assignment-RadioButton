import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame implements ActionListener {
    private JLabel pictureLabel;
    private Map<String, ImageIcon> petIcons;

    private final String birdString = "Bird";
    private final String catString = "Cat";
    private final String dogString = "Dog";
    private final String rabbitString = "Rabbit";
    private final String pigString = "Pig";

    public Main() {
        super("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        createPetImages();

        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setActionCommand(birdString);

        JRadioButton catButton = new JRadioButton(catString);
        catButton.setActionCommand(catString);

        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setActionCommand(dogString);

        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        rabbitButton.setActionCommand(rabbitString);

        JRadioButton pigButton = new JRadioButton(pigString);
        pigButton.setActionCommand(pigString);
        pigButton.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        JPanel radioPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        pictureLabel = new JLabel();
        pictureLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureLabel.setPreferredSize(new Dimension(240, 180));
        pictureLabel.setIcon(petIcons.get(pigString));

        add(radioPanel, BorderLayout.WEST);
        add(pictureLabel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = e.getActionCommand();
        pictureLabel.setIcon(petIcons.get(petName));

        JOptionPane.showMessageDialog(
            this,
            "You selected: " + petName,
            "Selection",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void createPetImages() {
        petIcons = new HashMap<>();
        petIcons.put(pigString, drawPig());
        petIcons.put(birdString, drawBird());
        petIcons.put(catString, drawCat());
        petIcons.put(dogString, drawDog());
        petIcons.put(rabbitString, drawRabbit());
    }

    private ImageIcon drawPig() {
        BufferedImage img = new BufferedImage(180, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(255, 192, 203));
        g.fillOval(35, 35, 110, 80);
        g.setColor(Color.BLACK);
        g.drawOval(35, 35, 110, 80);

        g.setColor(new Color(255, 182, 193));
        g.fillPolygon(new int[]{45, 60, 40}, new int[]{40, 20, 15}, 3);
        g.fillPolygon(new int[]{120, 105, 125}, new int[]{40, 20, 15}, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{45, 60, 40}, new int[]{40, 20, 15}, 3);
        g.drawPolygon(new int[]{120, 105, 125}, new int[]{40, 20, 15}, 3);

        g.setColor(new Color(255, 160, 180));
        g.fillOval(70, 70, 42, 28);
        g.setColor(Color.BLACK);
        g.drawOval(70, 70, 42, 28);
        g.fillOval(80, 79, 6, 9);
        g.fillOval(96, 79, 6, 9);

        g.fillOval(68, 52, 6, 6);
        g.fillOval(108, 52, 6, 6);

        g.drawArc(140, 60, 25, 25, 0, 270);
        g.dispose();
        return new ImageIcon(img);
    }

    private ImageIcon drawBird() {
        BufferedImage img = new BufferedImage(180, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(100, 180, 255));
        g.fillOval(45, 45, 80, 60);
        g.fillOval(100, 30, 45, 45);

        g.setColor(Color.BLACK);
        g.fillOval(125, 42, 6, 6);

        g.setColor(Color.ORANGE);
        g.fillPolygon(new int[]{140, 165, 140}, new int[]{45, 53, 60}, 3);

        g.setColor(new Color(60, 140, 220));
        g.fillArc(50, 55, 60, 40, 0, 180);
        g.dispose();
        return new ImageIcon(img);
    }

    private ImageIcon drawCat() {
        BufferedImage img = new BufferedImage(180, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(245, 165, 90));
        g.fillOval(50, 40, 80, 75);

        g.fillPolygon(new int[]{52, 70, 50}, new int[]{50, 20, 15}, 3);
        g.fillPolygon(new int[]{128, 110, 130}, new int[]{50, 20, 15}, 3);

        g.setColor(Color.GREEN.darker());
        g.fillOval(68, 62, 10, 14);
        g.fillOval(102, 62, 10, 14);

        g.setColor(Color.PINK);
        g.fillPolygon(new int[]{86, 94, 90}, new int[]{82, 82, 88}, 3);

        g.setColor(Color.BLACK);
        g.drawLine(60, 84, 40, 80);
        g.drawLine(60, 88, 40, 92);
        g.drawLine(120, 84, 140, 80);
        g.drawLine(120, 88, 140, 92);
        g.dispose();
        return new ImageIcon(img);
    }

    private ImageIcon drawDog() {
        BufferedImage img = new BufferedImage(180, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(205, 133, 63));
        g.fillOval(50, 35, 80, 80);

        g.setColor(new Color(139, 69, 19));
        g.fillOval(35, 45, 25, 55);
        g.fillOval(120, 45, 25, 55);

        g.setColor(Color.BLACK);
        g.fillOval(70, 58, 8, 8);
        g.fillOval(102, 58, 8, 8);

        g.setColor(new Color(222, 184, 135));
        g.fillOval(72, 72, 36, 28);

        g.setColor(Color.BLACK);
        g.fillOval(84, 76, 12, 10);
        g.dispose();
        return new ImageIcon(img);
    }

    private ImageIcon drawRabbit() {
        BufferedImage img = new BufferedImage(180, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(230, 230, 235));
        g.fillOval(68, 10, 16, 50);
        g.fillOval(96, 10, 16, 50);

        g.setColor(Color.PINK);
        g.fillOval(72, 18, 8, 35);
        g.fillOval(100, 18, 8, 35);

        g.setColor(new Color(240, 240, 245));
        g.fillOval(55, 45, 70, 65);

        g.setColor(new Color(180, 0, 50));
        g.fillOval(72, 66, 7, 9);
        g.fillOval(101, 66, 7, 9);

        g.setColor(Color.PINK);
        g.fillOval(87, 80, 6, 6);
        g.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
