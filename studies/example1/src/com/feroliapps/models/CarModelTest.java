package com.feroliapps.models;

import com.feroliapps.enums.ModelEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarModelTest {

    @Test
    public void validateContent() {
        assertEquals(ModelEnum.values().length,  2);
    }

}
