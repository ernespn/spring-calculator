package nestosoft.stackoverflow.questions;

import java.util.stream.Stream;

public interface SomeTypedRepository<T extends Something>{
    Stream<T> getTypedStream();
}
