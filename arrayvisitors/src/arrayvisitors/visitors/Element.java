package arrayvisitors.visitors;

import java.io.IOException;

public interface Element {
    public void accept(Visitor visitor) throws IOException;
}

