package ooptanks.version1.fieldobjects;

import java.awt.*;

public abstract class SimpleBFObjects implements BFObject {

    // current position on BF
    private int x;
    private int y;

    private boolean isDestroyable = true;

    protected Color color;

    protected boolean isDestroyed = false;

    public SimpleBFObjects(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void destroy() {
        isDestroyed = true;
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {
            g.setColor(this.color);
            g.fillRect(this.getX(), this.getY(), 64, 64);
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}