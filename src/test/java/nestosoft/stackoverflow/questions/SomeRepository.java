package nestosoft.stackoverflow.questions;

import java.util.stream.Stream;

public interface SomeRepository{
    Stream<? extends Something> getStream();
}


