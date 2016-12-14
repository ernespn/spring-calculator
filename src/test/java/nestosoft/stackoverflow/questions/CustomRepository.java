package nestosoft.stackoverflow.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomRepository implements  SomeRepository, SomeTypedRepository{

    @Override
    public Stream<? extends Something> getStream() {
        SomethingA a = new SomethingA();
        SomethingB b = new SomethingB();
        List<Something> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        return list.stream();
    }

    @Override
    public Stream getTypedStream() {
        SomethingA aa = new SomethingA();
        SomethingB bb = new SomethingB();
        List<Something> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        return list.stream();
    }


}
