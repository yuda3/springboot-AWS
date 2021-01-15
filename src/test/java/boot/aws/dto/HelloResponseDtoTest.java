package boot.aws.dto;

import boot.aws.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {

    @Test
    void test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        //then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);


    }

}
