package com.applaudostudios.ordermanagementapi.config.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

@DisplayName("Web Config Test")
class WebConfigTest {
    /**
     * Method under test: {@link WebConfig#modelMapper()}
     */
    @Test
    @DisplayName("Model Mapper Test")
    void testModelMapper() {
        ModelMapper actualModelMapperResult = (new WebConfig()).modelMapper();
        assertTrue(actualModelMapperResult.getTypeMaps().isEmpty());
    }
}

