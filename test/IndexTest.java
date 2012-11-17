import org.junit.Test;
import play.mvc.Content;
import play.data.Form;
import models.Task;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class IndexTest {

    @Test
    public void indexTemplate() {
    	Content html = views.html.index.render("test", new Form(Task.class));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("TEST");
    }

}