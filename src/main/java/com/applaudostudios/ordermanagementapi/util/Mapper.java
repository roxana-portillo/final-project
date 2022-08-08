package com.applaudostudios.ordermanagementapi.util;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

  public static <S, T> List<T> mapList(
      List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
    return source.stream()
        .map(element -> modelMapper.map(element, targetClass))
        .collect(Collectors.toList());
  }
}
