package sample;

import java.awt.*;
import java.net.URI;

public class googlemap {
    public static void main(String[] ars) throws Exception {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.google.com.bd/maps?source=tldsi&hl=en"));
    }
}
