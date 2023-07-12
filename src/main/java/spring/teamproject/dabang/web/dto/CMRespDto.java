package spring.teamproject.dabang.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class CMRespDto<T> {
    private int code;
    private String message;
    private T data;
}