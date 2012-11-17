import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import static org.fest.assertions.Assertions.assertThat;

import models.*;

public class DatabaseTest {

    @Test
    public void create() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Task task = new Task();
                task.contents = "Write a test";
                task.save();
                assertThat(task.id).isNotNull();
                
                Image image = new Image();
                try {
					image.img = ImageIO.read(new File("public/images/favicon.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
                image.desc = "test";
                image.save();
                assertThat(image.id).isNotNull();
                assertThat(image.img).isNotNull();
            }
        });
    }

}