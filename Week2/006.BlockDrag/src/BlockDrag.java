import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;

import static javafx.application.Application.launch;
import static javax.swing.UIManager.getColor;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

public class BlockDrag extends Application {
    ResizableCanvas canvas;
    private ArrayList<Rectangle> blocks;
    private Random random;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Block Dragging");
        primaryStage.show();

        canvas.setOnMousePressed(e -> mousePressed(e));
        canvas.setOnMouseReleased(e -> mouseReleased(e));
        canvas.setOnMouseDragged(e -> mouseDragged(e));

        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        blocks = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 10; i++) {
            blocks.add(new Rectangle(new Rectangle2D.Double(0, 0, 100, 100), new Point2D.Double(canvas.getWidth() * random.nextDouble(), canvas.getHeight() * random.nextDouble()), getColor(i)));
        }
    }



    public static void main(String[] args)
    {
        launch(BlockDrag.class);
    }

    private void mousePressed(MouseEvent e)
    {
    }

    private void mouseReleased(MouseEvent e)
    {

    }

    private void mouseDragged(MouseEvent e)
    {
    }

}
