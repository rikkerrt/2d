
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Point2D;


public class Rectangle {
    private Shape shape;
    private Color color;
    private Point2D location;


    public Rectangle(Shape shape, Point2D point2D, Color color) {
        this.shape = shape;
        this.color = color;
        this.location = point2D;
    }

    public void draw(FXGraphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.draw(getTransformedShape());
        graphics.setColor(color);
        graphics.fill(getTransformedShape());
    }

    public Shape getTransformedShape() {
        return getTransform().createTransformedShape(shape);
    }

    public AffineTransform getTransform() {
        AffineTransform transform = new AffineTransform();
        transform.translate(location.getX(), location.getY());
        return transform;
    }

    public void setPosition(Point2D position) {
        this.location = position;
    }

    public Point2D getPosition() {
        return location;
    }

    public Point2D getLocation() {
        return location;
    }

}
