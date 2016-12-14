package nestosoft.stackoverflow.questions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class somethingTests {

    @Mock
    private SomeRepository someRepository;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void ItShourReturnStreamFromRepository() {
        List<Something> list = new ArrayList<Something>();
        list.add(new Something());
        // This is what you think it should be here:
        // Stream<? extends Something> stream = list.stream();
        // But Actually the compiler likes this:
        Stream stream = list.stream();
        when(someRepository.getStream()).thenReturn(stream);


    }
}

