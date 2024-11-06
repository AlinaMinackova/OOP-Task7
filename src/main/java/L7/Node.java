package L7;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private  T value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<T> that = (Node<T>) o;
        return Objects.equals(value, that.value);
    }

}
