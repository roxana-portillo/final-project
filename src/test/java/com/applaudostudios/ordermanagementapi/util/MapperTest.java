package com.applaudostudios.ordermanagementapi.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class MapperTest {
  /** Method under test: {@link Mapper#mapList(List, Class, ModelMapper)} */
  @Test
  void testMapList() {
    ArrayList<Object> source = new ArrayList<>();
    Class<Object> targetClass = Object.class;
    assertTrue(Mapper.mapList(source, targetClass, new ModelMapper()).isEmpty());
  }

  /** Method under test: {@link Mapper#mapList(List, Class, ModelMapper)} */
  @Test
  void testMapList2() {
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Class<Object> targetClass = Object.class;
    assertEquals(1, Mapper.mapList(objectList, targetClass, new ModelMapper()).size());
  }

  /** Method under test: {@link Mapper#mapList(List, Class, ModelMapper)} */
  @Test
  void testMapList3() {
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    Class<Object> targetClass = Object.class;
    assertEquals(2, Mapper.mapList(objectList, targetClass, new ModelMapper()).size());
  }

  /** Method under test: {@link Mapper#mapList(List, Class, ModelMapper)} */
  @Test
  void testMapList4() {
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(2);
    Class<Object> targetClass = Object.class;
    assertEquals(1, Mapper.mapList(objectList, targetClass, new ModelMapper()).size());
  }
}
