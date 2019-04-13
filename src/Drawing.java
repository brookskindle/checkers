import java.awt.*;  // import canvas related stuff

public class Drawing extends Canvas {

    public static void main(String[] args) {
        Canvas c = new Drawing();
        c.setBackground(new Color(0x484A3A));
        c.setSize(400,400);

        Frame f = new Frame();
        f.add(c);
        f.pack();
        f.setVisible(true);
    }

    // paint gets called automatically by the Canvas when it is visible
    public void paint(Graphics g) {
        drawBoard(g);
        drawPlayers(g);
        //g.setColor(Color.RED);
        //g.fillRect(0,0, 50, 50);
        //g.fillRect(100,0, 50, 50);
        //g.fillRect(50, 50, 50, 50);
        //g.drawString("hello world", 100, 100);
    }

    public void drawPlayers(Graphics g) {
        drawPlayer1(g);
        drawPlayer2(g);
    }

    public void drawPlayer1(Graphics g) {
        g.setColor(Color.YELLOW);

        // TODO: use a single loop and check for odd/even rows
        for (int col=1; col<8; col+=2) {
            int row = 0;
            g.fillOval(50 * col, 50 * row, 50, 50);
        }
        for (int col=0; col<8; col+=2) {
            int row = 1;
            g.fillOval(50 * col, 50 * row, 50, 50);
        }
        for (int col=1; col<8; col+=2) {
            int row = 2;
            g.fillOval(50 * col, 50 * row, 50, 50);
        }
    }

    public void drawPlayer2(Graphics g) {
        Color tileColor = new Color(0x8ECD66); // indian green
        g.setColor(tileColor);
        int startRow = 5;

        // TODO: use a single loop and check for odd/even rows
        for (int row=startRow; row<8; row++) {
            int offset = 0;
            if (row % 2 == 0) {
                // even row, offset the board
                offset = 50;
            }
            for (int col = 0; col < 4; col++) {
                g.fillOval(100 * col + offset, 50 * row, 50, 50);
            }
        }
    }

    public void drawBoard(Graphics g) {
        Color tileColor = new Color(0xCD5C5C); // indian red
        g.setColor(tileColor);
        for (int row=0; row<8; row++) {
            int offset = 0;
            if (row % 2 == 1) {
                // odd row, offset the board
                offset = 50;
            }
            for (int col = 0; col < 4; col++) {
                g.fillRect(100 * col + offset, 50 * row, 50, 50);
            }
        }
    }
}
