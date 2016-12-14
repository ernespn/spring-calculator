package nestosoft.stackoverflow.questions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CustomRepositoryTest {

    @Test
    public void itShouldReturn2Somethings(){
        CustomRepository customRepository = new CustomRepository();

        Stream<? extends Something> stream = customRepository.getStream();

        Object[] array = stream.toArray();
        assertThat(array[0].getClass()).isEqualTo(SomethingA.class);
        assertThat(array[1].getClass()).isEqualTo(SomethingB.class);
    }

    @Test
    public void itShouldReturn2SomethingsWithTheTypedRepos(){
        CustomRepository customRepository = new CustomRepository();

        Stream<Something> stream = customRepository.getTypedStream();

        Object[] array = stream.toArray();
        assertThat(array[0].getClass()).isEqualTo(SomethingA.class);
        assertThat(array[1].getClass()).isEqualTo(SomethingB.class);
    }
}
