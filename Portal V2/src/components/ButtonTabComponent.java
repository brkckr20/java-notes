package components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class ButtonTabComponent extends JPanel {

    private final JTabbedPane tabbedPane;
    private Icon closeIcon;

    public ButtonTabComponent(final JTabbedPane tabbedPane) {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.tabbedPane = tabbedPane;
        setOpaque(false);
        closeIcon = new ImageIcon(getClass().getResource("Multiply.png"));

        JLabel label = new JLabel() {
            public String getText() {
                int index = tabbedPane.indexOfTabComponent(ButtonTabComponent.this);
                if (index != -1) {
                    return tabbedPane.getTitleAt(index);
                }
                return null;
            }
        };
        
        add(label);
        add(new CloseButton());
    }

    public class CloseButton extends JButton {

        public CloseButton() {
            int size = 17;
            setPreferredSize(new java.awt.Dimension(size, size));
            setToolTipText("Kapat");
            setUI(new javax.swing.plaf.basic.BasicButtonUI());
            setContentAreaFilled(false);
            setFocusable(false);
            setBorder(null);
            setBorderPainted(false);
            setRolloverEnabled(true);
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int index = tabbedPane.indexOfTabComponent(ButtonTabComponent.this);
                    if (index != -1) {
                        tabbedPane.remove(index);
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = getWidth() - closeIcon.getIconWidth() - 5;
            int y = (getHeight() - closeIcon.getIconHeight()) / 2;
            closeIcon.paintIcon(this, g, x, y);

        }
    }

}
