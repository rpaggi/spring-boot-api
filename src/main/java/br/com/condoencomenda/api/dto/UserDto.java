package br.com.condoencomenda.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude( JsonInclude.Include.NON_NULL )
public class UserDto {
    private Long id;
    private String name;
    private String user;
    private String password;
}
