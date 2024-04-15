package mate.academy.bookstore.dto;

import lombok.Data;

@Data
public class Response<T> {
    private int status;
    private T body;

    public Response(String message) {
    }
}
