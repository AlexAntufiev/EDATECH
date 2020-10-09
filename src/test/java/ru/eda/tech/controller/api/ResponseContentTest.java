package ru.eda.tech.controller.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.entity.dto.create.EntityCreateResponseDTO;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class ResponseContentTest extends JsonTestContext {

    private static Stream<Arguments> serializeData() {
        return Stream.of(
                of(ResponseContent.status(Status.SUCCESS)
                        .build(new EntityCreateResponseDTO(1L, "test")), "ResponseSuccess.json"),
                of(ResponseContent.success(new EntityCreateResponseDTO(1L, "test")), "ResponseSuccess.json"),
                of(ResponseContent.success(), "EmptyResponseSuccess.json"),
                of(ResponseContent.failed(Error.of("507", "Message 507")), "ResponseFailed.json"),
                of(ResponseContent.failed(), "EmptyResponseFailed.json")
        );
    }

    @ParameterizedTest
    @MethodSource("serializeData")
    public void shouldSerializeObjectToJson(Object srcObject, String expectedJsonFilename) {
        shouldSerialize(srcObject, expectedJsonFilename);
    }
}